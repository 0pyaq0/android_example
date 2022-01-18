package com.cookandroid.a0728;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtTel, edtAddress;
    RadioGroup rgGender;
    RadioButton rdoMan, rdoWoman;
    Button btnInput;

    String name, tel, address, gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtTel=findViewById(R.id.edtTel);
        rgGender=findViewById(R.id.reGender);
        rdoMan=findViewById(R.id.rdoMan);
        rdoWoman=findViewById(R.id.rdoWoman);
        btnInput=findViewById(R.id.btnInput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=edtName.getText().toString();
                tel=edtTel.getText().toString();
                address=edtAddress.getText().toString();

                if(rgGender.getCheckedRadioButtonId()==R.id.rdoMan){
                    gender="남자";
                }else{
                    gender="여자";
                }
                Person p = new Person(name, tel, address, gender);
                Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                in.putExtra("person", p);
                startActivity(in);

            }
        });
    }
}
