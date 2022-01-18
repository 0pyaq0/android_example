package com.cookandroid.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second");
        Button btn2 = findViewById(R.id.btn2);
        TextView txtContent = findViewById(R.id.txtContent);

        Intent in = getIntent();
        String name = in.getStringExtra("name");
        int age = in.getIntExtra("age", 0);
        ArrayList<String> hobby = in.getStringArrayListExtra("hobby");

        txtContent.setText("이름 : "+name+"\n 나이 : "+age+"\n 취미 : ");
        for(String h:hobby){
            txtContent.setText(txtContent.getText().toString()+h+" ");
        }
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
