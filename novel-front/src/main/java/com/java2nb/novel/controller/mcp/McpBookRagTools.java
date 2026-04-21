package com.java2nb.novel.controller.mcp;

import lombok.extern.slf4j.Slf4j;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class McpBookRagTools {
    private final VectorStore vectorStore;  // ChromaVectorStore（已自动注入）


    public McpBookRagTools(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    /**
     * 同步 RAG 查询工具 - 供 MCP 客户端（如 Open WebUI）调用
     */
    @GetMapping("mcp/rag_query")
    @McpTool(name = "rag_query", description = "使用知识库（Chroma）进行 RAG 查询，返回最准确的答案。输入用户问题即可。")
    public List<Document> ragQuery(@McpToolParam(description = "用户的问题（必填）") @RequestParam("question") String question) {
        SearchRequest request = SearchRequest.builder()
                .query(question)
                .topK(5)
                .similarityThreshold(0.2)
                .build();
        var result = vectorStore.similaritySearch(request);
        return result;
    }
}
