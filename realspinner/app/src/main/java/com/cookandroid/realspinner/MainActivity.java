package com.cookandroid.realspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spMovie;
    ImageView imgPoster;
    ArrayAdapter<String>adapter;
    String[] titles = {"쿵푸팬더", "짱구는 못말려", "아저씨", "아바타", "대부", "국가대표",
            "토이스토리", "마당을 나온 암탉", "죽은 시인의 사회", "서유기"};
    Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spMovie = findViewById(R.id.spMovie);
        imgPoster = findViewById(R.id.imgPoster);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, titles);
        spMovie.setAdapter(adapter);
        spMovie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imgPoster.setImageResource(posterID[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
