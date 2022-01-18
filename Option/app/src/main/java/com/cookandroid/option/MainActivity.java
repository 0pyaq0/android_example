package com.cookandroid.option;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[심이진]옵션메뉴 연습");

        baseLayout = (LinearLayout)findViewById(R.id.BaseLayout);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "옵션메뉴 연습", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemRed: baseLayout.setBackgroundColor(Color.RED); break;
            case R.id.itemGreen: baseLayout.setBackgroundColor(Color.GREEN); break;
            case R.id.itemGray: baseLayout.setBackgroundColor(Color.GRAY); break;
            case R.id.subRotate: btn.setRotation(45); return true;
            case R.id.subSize: btn.setScaleX(2); return true;
            case R.id.subReturn: btn.setRotation(0); btn.setScaleX(1); return true;
        }
        return false;
    }
}
