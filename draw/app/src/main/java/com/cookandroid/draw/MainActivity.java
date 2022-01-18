package com.cookandroid.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2, btn3;
    ImageView img;
    float angle=0;
    int on=1;
    int imgtype=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        img = (ImageView) findViewById(R.id.img);
        int i = 0;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle+=10;
                img.setRotation(angle);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(on==1) {
                    img.setVisibility(View.VISIBLE);
                    on = 0;
                }else
                {img.setVisibility(View.INVISIBLE);
                on=1;}
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(imgtype==1){
                img.setImageResource(R.drawable.q10);
                imgtype=0;
            }else{
                img.setImageResource(R.drawable.api23);
                imgtype=1;
            }

            }
        });
    }
}
