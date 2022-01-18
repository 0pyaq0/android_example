package com.cookandroid.a07301;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    Car[]mdata;
    public CustomAdapter(Context mContext, Car[]mdata){
        this.mContext=mContext;
        this.mdata=mdata;
    }
    @Override
    public int getCount(){return mdata.length;}

    @Override
    public Object getItem(int i){return mdata[i];}

    @Override
    public long getItemId(int i){return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        if(view==null){
            view=View.inflate(mContext, R.layout.car_child_view, null);
        }
        Car tempCar = mdata[i];
        ImageView carIV = (ImageView)view.findViewById(R.id.imageView1);
        TextView carTV = (TextView)view.findViewById(R.id.textView1);
        carIV.setImageResource(tempCar.getImage_id());
        carTV.setText(tempCar.getName());
        return view;
    }
}
