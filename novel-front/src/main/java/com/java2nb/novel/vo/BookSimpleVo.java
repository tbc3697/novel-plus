package com.java2nb.novel.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BookSimpleVo {
    private Long bookId;
    private String bookName;
    private String authorName;
    private String bookDesc;
}
