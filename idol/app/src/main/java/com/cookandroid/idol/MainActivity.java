package com.cookandroid.idol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnOk;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("라디오버튼[심이진]");

        Button btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.rbRed:
                        Toast.makeText(getApplicationContext(), "드림을 선택하였습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbGreen:
                        Toast.makeText(getApplicationContext(), "투바투을 선택하였습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbBlue:
                        Toast.makeText(getApplicationContext(), "에스파을 선택하였습니다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
