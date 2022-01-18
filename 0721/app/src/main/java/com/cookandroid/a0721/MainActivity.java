package com.cookandroid.a0721;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    ImageView img1, img2;
    int imageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("레이아웃 [심이진]");
        btn1 = (Button)findViewById(R.id.btn1);
        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
            }
        });
    }
    private void changeImage(){
        if(imageIndex==0){
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
            imageIndex=1;
        }else if(imageIndex==1){
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
            imageIndex=0;
        }
    }
}
