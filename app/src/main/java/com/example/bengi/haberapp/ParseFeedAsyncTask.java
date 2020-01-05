package com.example.bengi.haberapp;


import java.util.List;
import android.os.AsyncTask;

public class ParseFeedAsyncTask extends AsyncTask<Void, Void, List<Rss>> {
    private static final String feedUrl = "http://feeds.bbci.co.uk/turkce/rss.xml";
    private ParseFeedCallback   callback;
    public ParseFeedAsyncTask(ParseFeedCallback callback) {
        this.callback = callback;
    }
    @Override
    //yapılacak işlemleri belirledik.İnternet bağlantısı ve hangi urlden veri çekileceğını belirtip parçalanmak üzere rssparsera yoladık
    protected List<Rss> doInBackground(Void... params) {
        String xmlContent = Downloader.getContent(feedUrl);
        return RssParser.parseFeed(xmlContent);
    }
    @Override
    //işlem bitince yapması gerekneleri belirttik.
    protected void onPostExecute(List<Rss> result) {
        super.onPostExecute(result);
        callback.finishedLoadingFeeds(result);
    }
}