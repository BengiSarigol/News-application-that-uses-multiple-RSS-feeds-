package com.example.bengi.haberapp;



public class Rss {

    private String title;
    private String content;
    private String postDate;
    private String originalPostUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public String getOriginalPostUrl() {
        return originalPostUrl;
    }

    public void setOriginalPostUrl(String originalPostUrl) {
        this.originalPostUrl = originalPostUrl;
    }
}