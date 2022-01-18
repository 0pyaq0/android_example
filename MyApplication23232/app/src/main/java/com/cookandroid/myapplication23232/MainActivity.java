package com.cookandroid.myapplication23232;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {
        EditText start, end;
        Button btn1, btn2;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("1주차실습 - 심이진");
            start = (EditText) findViewById(R.id.start);
            end = (EditText) findViewById(R.id.end);
            btn1=(Button)findViewById(R.id.btn1);
            btn2=(Button)findViewById(R.id.btn2);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int x=Integer.parseInt(start.getText().toString());
                    int y=Integer.parseInt(end.getText().toString());
                    int z = 0;
                    for(int i = x; i <= y; i++){
                        if(i%2==0){
                            z += i;
                        }
                    }
                    Toast.makeText(getApplicationContext(), z, Toast.LENGTH_LONG).show();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int x=Integer.parseInt(start.getText().toString());
                    int y=Integer.parseInt(end.getText().toString());
                    int z= (y/x)*x;
                    if(y<x){
                        Toast.makeText(getApplicationContext(), "가용할 포인트가 부족합니다.", Toast.LENGTH_LONG).show();
                    }else
                        Toast.makeText(getApplicationContext(), z, Toast.LENGTH_LONG).show();
                }
            });
        }
    }