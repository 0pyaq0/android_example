package com.cookandroid.a0729;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        Button btnC = findViewById(R.id.btnC);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inc = new Intent(getApplicationContext(), ThirdActivity.class);
                inc.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(inc);
            }
        });
    }
}
