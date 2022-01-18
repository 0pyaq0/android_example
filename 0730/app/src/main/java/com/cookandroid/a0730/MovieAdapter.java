package com.cookandroid.a0730;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Movie>mdata;

    public MovieAdapter(Context mContext, ArrayList<Movie>mdata){
        this.mContext=mContext;
        this.mdata=mdata;
    }

    @Override
    public int getCount(){return mdata.size();}

    @Override
    public Object getItem(int position){return mdata.get(position);}

    @Override
    public long getItemId(int position){return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.listitem, null);
        }
        TextView title = (TextView)convertView.findViewById(R.id.txtTitle);
        TextView genre = (TextView)convertView.findViewById(R.id.txtGenre);
        ImageView image = (ImageView) convertView.findViewById(R.id.imgPoster);

        image.setImageDrawable(mdata.get(position).image);
        title.setText(mdata.get(position).title);
        genre.setText(mdata.get(position).genre);

        return convertView;
    }
}
