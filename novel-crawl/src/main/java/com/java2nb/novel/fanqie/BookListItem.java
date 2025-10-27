package com.java2nb.novel.fanqie;

import lombok.Data;

@Data
public class BookListItem {
    // 使用abstract遇到了关键字，所以加了Text以规避
    // private String abstractText;
    private String author;
    private String book_id;
    private String bookName;
    private int creationStatus;
    private String lastChapterTime;
    private String readCount;
    private int status;
    private String thumbUri;
    private String thumbUrl;
    private String wordCount;

    // public String getAbstract() {
    //     return abstractText;
    // }

}
