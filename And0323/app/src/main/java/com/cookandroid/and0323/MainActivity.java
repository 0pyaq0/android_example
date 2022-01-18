package com.cookandroid.and0323;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edName;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName=(EditText)findViewById(R.id.etName);
        btn=(Button)findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString(); //Edit에 입력한 글자를 가져와서 String에 저장
                Toast.makeText(getApplicationContext(),"당신이 입력한 글자는 ["+name + "] 입니다.", Toast.LENGTH_LONG).show();

            }
        });
    }
}
