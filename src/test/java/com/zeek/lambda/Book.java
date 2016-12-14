package com.zeek.lambda;

import java.util.List;

/**
 * Created by weibo_li on 16/8/25.
 */
public class Book {

    public Book(String title, List<String> authors, int[] pageCounts) {
        this.title = title;
        this.authors = authors;
        this.pageCounts = pageCounts;
    }

    private String title;

    private List<String> authors;

    private int[] pageCounts;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int[] getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(int[] pageCounts) {
        this.pageCounts = pageCounts;
    }
}
