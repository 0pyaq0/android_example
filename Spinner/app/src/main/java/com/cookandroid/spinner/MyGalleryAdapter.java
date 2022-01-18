package com.cookandroid.spinner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MyGalleryAdapter extends BaseAdapter {

    Context context;
    Integer[] poster;

    public MyGalleryAdapter(Context c, Integer[] p) { context=c; poster=p;}

    @Override
    public int getCount() { return poster.length;}
    @Override
    public Object getItem(int arg0) { return null;}
    @Override
    public long getItemId(int position) {return 0;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(poster[position]);
        return imageView;
    }
}
