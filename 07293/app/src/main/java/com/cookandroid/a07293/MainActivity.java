package com.cookandroid.a07293;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridView; MovieAdapter adapter;
    Integer[] posters = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10, R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};
    String[] titles = {"토이스토리", "호빗", "제이슨본", "반지의 제왕", "정직한 후보", "나쁜 녀석들", "겨울왕국", "알라딘", "극한직업", "스파이더맨", "토이스토리", "호빗", "제이슨본", "반지의 제왕", "정직한 후보", "나쁜 녀석들", "겨울왕국", "알라딘", "극한직업", "스파이더맨"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        adapter=new MovieAdapter(posters);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                View v = (View)View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                ImageView iv = v.findViewById(R.id.imgdlg);
                iv.setImageResource(posters[i]);
                dlg.setTitle(titles[i]); dlg.setView(v);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

    }
}
