package com.example.bengi.haberapp;


import java.util.List;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

    private List<Rss>      rssList;
    private LayoutInflater inflater;
    private Context        context;


    public ListAdapter(Context context, List<Rss> rssList) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.rssList = rssList;
        this.context = context;

    }

    @Override
    public int getCount() {
        return rssList.size();
    }

    @Override
    public Object getItem(int position) {
        return rssList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup arg2) {
        Rss rss = rssList.get(position);
        View rowView = view;
        TextView txtTitle;
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.haber_listesi, null);
            txtTitle = (TextView) rowView.findViewById(R.id.haber);

        }

        txtTitle = (TextView) rowView.findViewById(R.id.haber);
        txtTitle.setText(rss.getTitle());
        return rowView;
    }
}

