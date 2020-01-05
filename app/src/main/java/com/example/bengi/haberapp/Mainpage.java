package com.example.bengi.haberapp;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class Mainpage extends Activity implements ParseFeedCallback {
    private ListView listView;
    String spor= "spor", turkiye="turkiye";

    String Channel_id = "haber";
    String Channel_name = "Haberler";
    int Notification_id=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lvRss);

      Bildirim();


        Intent intent = getIntent();
        String btntr = intent.getStringExtra("tr");
        String btnspor = intent.getStringExtra("sp");
        String btnfinans = intent.getStringExtra("fn");

        String btn = null;
        
        if(btnspor != null){
            btn = "spor";
        }else if (btntr != null){
            btn = "turkiye";
        }else if(btnfinans != null){
            btn = "finans";
        }

        Log.d("buttonla gelen değer" ," " +btn);


    

        if (btn == "turkiye") {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Rss rss = (Rss) listView.getAdapter().getItem(position);
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rss.getOriginalPostUrl().trim()));
                    startActivity(browserIntent);
                }
            });

            new ParseFeedAsyncTask(this).execute((Void) null);
        } else if (btn == "spor") {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Rss rss = (Rss) listView.getAdapter().getItem(position);
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rss.getOriginalPostUrl().trim()));
                    startActivity(browserIntent);
                }
            });

            new ParseFeedSpor(this).execute((Void) null);
        }else if (btn == "finans") {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Rss rss = (Rss) listView.getAdapter().getItem(position);
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rss.getOriginalPostUrl().trim()));
                    startActivity(browserIntent);
                }
            });

            //doinbackground methoduna nesne göndermiyorum ondan execute :null
            new ParseFeedFinans(this).execute((Void) null);
        }


    }
    @Override
    public void finishedLoadingFeeds (List< Rss > feeds) {
        listView.setAdapter(new ListAdapter(getApplicationContext(), feeds));
    }

    public void Bildirim(){
        Intent intenttt = new Intent(this, MainActivity.class);
        intenttt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intenttt, 0);
        Notification myNotify  = new Notification.Builder(this)
                .setContentTitle("Haberler")
                .setContentText("Haber başlıklarına dönmek için tıklayınız ya da geri tuşunu kullanınız.")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentIntent(pIntent) //Bildirime tıklandığında açılacak olan activity sayfasını işaret eder.
                .setAutoCancel(true).build();//bildirime girilince bildirim silinsin true;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, myNotify);
    }

}