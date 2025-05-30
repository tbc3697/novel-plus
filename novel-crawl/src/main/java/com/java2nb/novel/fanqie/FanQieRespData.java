package com.java2nb.novel.fanqie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class FanQieRespData<T> {
    private final List<T> bookList;
    private final String hasMore;
    private final String totalCount;
}
