package com.cookandroid.a0728;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView txtResult;
    Person p;
    String name, tel, address, gender;
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        txtResult=findViewById(R.id.txtResult);
        btnResult=findViewById(R.id.btnReturn);

        Intent in = getIntent();
        p=(Person)in.getSerializableExtra("person");
        name=p.getName();
        gender=p.getGender();
        tel=p.getTel();
        address=p.getAddress();
        txtResult.setText("이름 : "+name+"\n"+"성별 : "+gender+"\n");
        txtResult.setText(txtResult.getText().toString()+"전화 : "+tel+"\n");
        txtResult.setText(txtResult.getText().toString()+"주소 : "+address+"\n");

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
