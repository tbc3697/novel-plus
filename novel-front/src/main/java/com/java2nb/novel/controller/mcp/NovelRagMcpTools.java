package com.java2nb.novel.controller.mcp;

import dev.langchain4j.store.embedding.EmbeddingMatch;
import dev.langchain4j.store.embedding.chroma.ChromaEmbeddingStore;
import lombok.extern.slf4j.Slf4j;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class NovelRagMcpTools {

    private final ChromaEmbeddingStore embeddingStore;   // LangChain4j 的 ChromaVectorStore
    private final EmbeddingModel embeddingModel;

    public NovelRagMcpTools(ChromaEmbeddingStore embeddingStore, EmbeddingModel embeddingModel) {
        this.embeddingStore = embeddingStore;
        this.embeddingModel = embeddingModel;
    }

    /**
     * MCP Tool：query_novel_rag
     * Open WebUI 通过 MCP Streamable HTTP 直接调用
     */
    @McpTool(name = "query_novel_rag",
            description = "根据自然语言查询小说库，返回最相关章节内容（支持元数据过滤）")
    @Async("mcpToolExecutor")   // 使用你之前配置的异步线程池
    public SseEmitter queryNovelRag(
            @ToolParam(description = "查询关键词，例如：系统流金手指 重生 都市") String query,
            @ToolParam(description = "返回数量，默认 5") int topK) {

        SseEmitter emitter = new SseEmitter(300_000L);  // 5分钟超时

        CompletableFuture.runAsync(() -> {
            try {
                // 1. 嵌入 query（用 bge-m3）
                OpenAiApi.Embedding queryEmbedding = embeddingModel.embed(query).content();

                // 2. Chroma 相似度检索（LangChain4j 原生）
                List<EmbeddingMatch<Document>> matches = embeddingStore.findRelevant(
                        queryEmbedding,
                        topK > 0 ? topK : 5,
                        0.0  // 相似度阈值，可调
                );

                emitter.send(SseEmitter.event()
                        .name("start")
                        .data("🚀 RAG 检索开始: " + query));

                for (EmbeddingMatch<Document> match : matches) {
                    Document doc = match.embedded();
                    String resultChunk = String.format(
                            "【书名】%s\n【章节序号】%s\n【章节标题】%s\n【相关度】%.3f\n【内容片段】%s...\n\n",
                            doc.metadata().get("book_name"),
                            doc.metadata().get("chapter_order"),
                            doc.metadata().get("chapter_title"),
                            match.score(),
                            doc.text().substring(0, Math.min(700, doc.text().length()))
                    );

                    emitter.send(SseEmitter.event()
                            .name("chunk")
                            .data(resultChunk));
                    Thread.sleep(40); // 流式视觉效果
                }

                emitter.send(SseEmitter.event()
                        .name("end")
                        .data("✅ 检索完成，共返回 " + matches.size() + " 条结果"));
                emitter.complete();

            } catch (Exception e) {
                log.error("RAG 查询异常", e);
                try {
                    emitter.send(SseEmitter.event().name("error").data(e.getMessage()));
                } catch (Exception ignored) {
                }
                emitter.completeWithError(e);
            }
        }, mcpToolExecutor());

        return emitter;
    }
}
