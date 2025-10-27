package com.java2nb.novel.fanqie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class FanQieRespData {
    private final List<BookListItem> book_list;
    private final boolean has_more;
    private final int total_count;
}
