package com.cookandroid.a0722one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    LinearLayout baselay;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.dog: img.setImageResource(R.drawable.dog2); break;
            case R.id.cat: img.setImageResource(R.drawable.cat); break;
            case R.id.rab: img.setImageResource(R.drawable.rabbit); break;
        }
        super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("실습 1 [심이진]");
        img = findViewById(R.id.img);
        baselay = findViewById(R.id.baseLay);


    }
}
