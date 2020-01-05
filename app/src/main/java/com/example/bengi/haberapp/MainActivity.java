package com.example.bengi.haberapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Calendar;



import static android.content.ContentValues.TAG;

public class MainActivity extends Activity  {
    CardView turkiye,dunya,spor,finans;

    private AlarmManager alarmmanager;
    private PendingIntent alarmintent;


    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);




        //wifi bağlantı kontrolü saat başı yapılıyor
        Context context = this;
       alarmmanager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, WifiReceiver.class);
        alarmintent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),1000*60*60, alarmintent);





        turkiye = (CardView) findViewById(R.id.turkiye);
        finans = (CardView)  findViewById(R.id.finans);
        spor   =  (CardView) findViewById(R.id.spor);





        turkiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Mainpage.class);

                intent.putExtra("tr","turkiye");
                startActivity(intent);
            }
        });
        spor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Mainpage.class);
                intent.putExtra("sp","spor");

                startActivity(intent);
            }
        });
        finans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Mainpage.class);
                intent.putExtra("fn","finans");
                startActivity(intent);
            }
        });

    }

}