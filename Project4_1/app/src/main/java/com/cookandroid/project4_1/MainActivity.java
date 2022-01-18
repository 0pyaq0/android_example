package com.cookandroid.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView txtResult;

    public void btnClick(View view){
        switch(view.getId()){
            case R.id.btnOnClick1:
                Toast.makeText(getApplicationContext(), "버튼OnClick1 선택", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnOnClick2:
                Toast.makeText(getApplicationContext(), "버튼OnClick2 선택", Toast.LENGTH_LONG).show();
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미림 심이진");
        edt1 =(EditText)findViewById(R.id.Edit1);
        edt2 =(EditText)findViewById(R.id.Edit2);

        btnAdd =(Button)findViewById(R.id.BtnAdd);
        btnSub =(Button)findViewById(R.id.BtnSub);
        btnMul =(Button)findViewById(R.id.BtnMul);
        btnDiv =(Button)findViewById(R.id.BtnDiv);

        txtResult =(TextView)findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = edt1.getText().toString(); //EditText에서 입력한 숫자 가져오기
                int x=Integer.parseInt(str1); //정수형 반환
                int y=Integer.parseInt(edt2.getText().toString()); //EditText에서 바로 가져와서 정수형으로 변환
                // int z = x+y;
                txtResult.setText("계산 결과 : " + (x+y)); // txtResult.setText("계산 결과 : " + z);

            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x=Integer.parseInt(edt1.getText().toString());
                int y=Integer.parseInt(edt2.getText().toString());
                txtResult.setText("계산 결과 : " + (x-y));
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x=Integer.parseInt(edt1.getText().toString());
                int y=Integer.parseInt(edt2.getText().toString());
                txtResult.setText("계산 결과 : " + (x*y));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x=Integer.parseInt(edt1.getText().toString());
                int y=Integer.parseInt(edt2.getText().toString());
                txtResult.setText("계산 결과 : " + (x/y));
            }
        });

    }
}
