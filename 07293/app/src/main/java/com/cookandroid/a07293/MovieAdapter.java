package com.cookandroid.a07293;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MovieAdapter extends BaseAdapter {
    Integer[] img;
    MovieAdapter(Integer[] img){this.img=img;}

    @Override
    public int getCount(){return img.length;}

    @Override
    public Object getItem(int i){return null;}

    @Override
    public long getItemId(int i){return 0;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        ImageView imgV;
        if(view==null){
            view=View.inflate(viewGroup.getContext(), R.layout.item, null);
        }
        imgV=view.findViewById(R.id.imgMovie);
        imgV.setImageResource(img[i]);
        return view;
    }
}
