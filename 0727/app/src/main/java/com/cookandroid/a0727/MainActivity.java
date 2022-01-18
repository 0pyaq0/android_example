package com.cookandroid.a0727;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String name;
    Button btn;
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("심이진");
        btn=findViewById(R.id.btn);
        edt=findViewById(R.id.edt1);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        name = sharedPreferences.getString("name", "이름없음");
        edt.setText(name);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor = sharedPreferences.edit();
                name=edt.getText().toString();
                editor.putString("name", name);
                editor.commit();
            }
        });

    }
}
