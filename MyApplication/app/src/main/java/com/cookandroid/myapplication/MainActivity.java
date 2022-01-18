package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button btnPre, btnNext, btnStart, btnStop;
    ViewFlipper viewFlip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPre = (Button)findViewById(R.id.btnPre);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnNext = (Button)findViewById(R.id.btnNext);
        btnStop = (Button)findViewById(R.id.btnStop);

        viewFlip = (ViewFlipper)findViewById(R.id.viewFlip);
        viewFlip.setFlipInterval(500);

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlip.showPrevious();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlip.stopFlipping();
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlip.startFlipping();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlip.showNext();
            }
        });
    }
}
