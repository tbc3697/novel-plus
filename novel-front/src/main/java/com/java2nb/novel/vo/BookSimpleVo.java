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
@Schema(description = "一本书的部分主要属性")
public class BookSimpleVo {
    @Schema(description = "bookid, 一本书的唯一标识")
    private Long bookId;
    @Schema(description = "书籍名称")
    private String bookName;
    @Schema(description = "作者名称")
    private String authorName;
    @Schema(description = "书的内容简介")
    private String bookDesc;
    @Schema(description = "书本内容的总字数")
    private Integer wordCount;
}
