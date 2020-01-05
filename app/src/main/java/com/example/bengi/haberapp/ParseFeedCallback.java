package com.example.bengi.haberapp;

import java.util.List;


public interface ParseFeedCallback {
    public void finishedLoadingFeeds(List<Rss> feeds);
}
