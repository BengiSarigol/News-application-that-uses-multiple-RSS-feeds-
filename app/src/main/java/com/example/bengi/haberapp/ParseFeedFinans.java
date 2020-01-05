package com.example.bengi.haberapp;

import android.os.AsyncTask;

import java.util.List;

public class ParseFeedFinans   extends AsyncTask<Void, Void, List<Rss>> {
    private static final String feedUrl = "https://www.ekonomidunya.com/rss_ekonomi_1.xml";
    private ParseFeedCallback   callback;
    public ParseFeedFinans(ParseFeedCallback callback) {
        this.callback = callback;
    }
    @Override
    protected List<Rss> doInBackground(Void... params) {
        String xmlContent = Downloader.getContent(feedUrl);
        return RssParser.parseFeed(xmlContent);
    }
    @Override
    protected void onPostExecute(List<Rss> result) {
        super.onPostExecute(result);
        callback.finishedLoadingFeeds(result);
    }
}

