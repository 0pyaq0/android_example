package com.cookandroid.a0720radio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    EditText intent;
    RadioGroup rg;
    RadioButton rb1, rb2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("라디오버튼[심이진]");

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        intent = findViewById(R.id.intent);
        rb2= (RadioButton)findViewById(R.id.rb2);
        rb1= (RadioButton)findViewById(R.id.rb1);
        img = (ImageView)findViewById(R.id.img);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), intent.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse(intent.getText().toString()));
                startActivity(urlOpen);
            }
        });

        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rb1.isChecked()==true){
                    img.setImageResource(R.drawable.ic_launcher);
                }
            }
        });

        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rb2.isChecked()==true){
                    img.setImageResource(R.drawable.oreo);
                }
            }
        });
    }
    /*public void onRadioButtonCliked(View v){
        boolean checked = ((RadioButton) v).isChecked();
        if(checked) Toast.makeText(getApplicationContext(), ((RadioButton) v).getText()+"checked",Toast.LENGTH_LONG).show();
        else Toast.makeText(getApplicationContext(), ((RadioButton) v).getText()+"unchecked",Toast.LENGTH_LONG).show();
    }*/
}
