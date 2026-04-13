package com.java2nb.novel.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Schema(description = "这表示一本book的一个章节的简要字段")
public class BookIndexSimpleVo {
    @Schema(description = "书本id, bookId, 表示一本书")
    private Long bookId;
    @Schema(description = "章节id， 也叫目录id， 在单本书表示一个章节")
    private Long bookIndexId;
    @Schema(description = "章节名称，也叫目录名称")
    private String indexName;
    @Schema(description = "字数，表示一个章节内容的总字数")
    private Integer wordCount;
}
