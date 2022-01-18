package com.cookandroid.a07211;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText x, y, answer;
    Spinner op1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기 [심이진]");
        btn = (Button)findViewById(R.id.btn);
        x = (EditText)findViewById(R.id.x);
        y = (EditText)findViewById(R.id.y);
        answer = (EditText)findViewById(R.id.answer);
        op1 = (Spinner)findViewById(R.id.op1);

        op1.setSelection(0);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int i= op1.getSelectedItemPosition();
                    int x1 = Integer.parseInt(x.getText().toString());
                    int y1 = Integer.parseInt(y.getText().toString());
                    int result = 0;
                    if(i==0)result = x1+y1;
                    else if(i==1)result = x1 - y1;
                    else if(i==2)result = x1*y1;
                    else result = x1%y1;
                    answer.setText(result+" ");
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
