package com.example.bengi.haberapp;

import android.os.AsyncTask;

import java.util.List;

public class ParseFeedSpor  extends AsyncTask<Void, Void, List<Rss>> {
    private static final String feedUrl = "http://spor.mynet.com/rss";
    private ParseFeedCallback   callback;
    public ParseFeedSpor(ParseFeedCallback callback) {
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
