package com.cookandroid.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("1주차실습 - 심이진");
        Num = (EditText) findViewById(R.id.Num);

        Num.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String str = "입력한 학과는 " + Num.getText().toString();
                if(i==KeyEvent.KEYCODE_ENTER)
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }
}
