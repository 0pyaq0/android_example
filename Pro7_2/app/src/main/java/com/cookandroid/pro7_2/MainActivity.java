package com.cookandroid.pro7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnColor, btnChange, btnGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[심이진] 컨텍스트 메뉴 연습");

        btnColor = (Button) findViewById(R.id.btnColor);
        btnChange = (Button) findViewById(R.id.btnChange);
        btnGrade = (Button) findViewById(R.id.btnGrade);
btnGrade.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        PopupMenu p = new PopupMenu(getApplicationContext(), view);
        getMenuInflater().inflate(R.menu.pop, p.getMenu());

        p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item1:
                        Toast.makeText(getApplicationContext(), "1학년입니다.", Toast.LENGTH_LONG).show();
                    case R.id.item2:
                        Toast.makeText(getApplicationContext(), "2학년입니다.", Toast.LENGTH_LONG).show();
                    case R.id.item3:
                        Toast.makeText(getApplicationContext(), "3학년입니다.", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
        p.show();
    }
});
        registerForContextMenu(btnChange);
        registerForContextMenu(btnColor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if(v==btnColor){
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.menu1, menu);
        }
        if(v==btnChange){
            menu.setHeaderTitle("버튼 변경");
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemRed:
                btnColor.setBackgroundColor(Color.RED); return true;
            case R.id.itemGreen:
                btnColor.setBackgroundColor(Color.GREEN); return true;
            case R.id.itemWhite:
                btnColor.setBackgroundColor(Color.parseColor("#DDDDDD")); return true;
            case R.id.itemRotate:
                btnChange.setRotation(45); return true;
            case R.id.itemSize:
                btnChange.setScaleX(2); return true;
            case R.id.itemReturn:
                btnChange.setScaleX(1);
                btnChange.setRotation(0); return true;
        }
        return super.onContextItemSelected(item);
    }
}
