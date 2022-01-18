package com.cookandroid.a0721frame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnData, btnInput, btnOutput, btnInputOk, btnOutputOk;
    LinearLayout layData, layInput, layOutput;
    TextView txtData;
    EditText edtInput, edtOutput;
    int total = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("심이진");
        btnData = (Button)findViewById(R.id.btnData);
        btnInput = (Button)findViewById(R.id.btnInput);
        btnOutput = (Button)findViewById(R.id.btnOutput);
        btnInputOk = (Button)findViewById(R.id.btnInputOk);
        btnOutputOk = (Button)findViewById(R.id.btnOutputOk);
        layData = (LinearLayout)findViewById(R.id.layData);
        layInput = (LinearLayout)findViewById(R.id.layInput);
        layOutput = (LinearLayout)findViewById(R.id.layOutput);
        edtInput = (EditText)findViewById(R.id.edtInput);
        edtOutput = (EditText) findViewById(R.id.edtOutput);
        txtData = (TextView)findViewById(R.id.txtData);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnData.setBackgroundColor(Color.parseColor("#F4F47F"));
                btnInput.setBackgroundColor(Color.parseColor("E1DDDD"));
                btnOutput.setBackgroundColor(Color.parseColor("E1DDDD"));
                layData.setVisibility(View.VISIBLE);
                layInput.setVisibility(View.INVISIBLE);
                layOutput.setVisibility(View.INVISIBLE);
            }
        });

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnData.setBackgroundColor(Color.parseColor("E1DDDD"));
                btnInput.setBackgroundColor(Color.parseColor("#F4F47F"));
                btnOutput.setBackgroundColor(Color.parseColor("E1DDDD"));
                layData.setVisibility(View.INVISIBLE);
                layInput.setVisibility(View.VISIBLE);
                layOutput.setVisibility(View.INVISIBLE);
            }
        });

        btnOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnData.setBackgroundColor(Color.parseColor("E1DDDD"));
                btnInput.setBackgroundColor(Color.parseColor("E1DDDD"));
                btnOutput.setBackgroundColor(Color.parseColor("#F4F47F"));
                layData.setVisibility(View.INVISIBLE);
                layInput.setVisibility(View.INVISIBLE);
                layOutput.setVisibility(View.VISIBLE);
            }
        });

        btnInputOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtInput.getText().toString());
                total +=n;
                txtData.setText("잔액 : " + total+"원");
                edtInput.setText("0");
            }
        });

        btnOutputOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtInput.getText().toString());
                total -=n;
                txtData.setText("잔액 : " + total+"원");
                edtInput.setText("0");
            }
        });

    }
}
