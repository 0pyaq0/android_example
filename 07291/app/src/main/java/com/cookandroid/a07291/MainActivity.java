package com.cookandroid.a07291;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button btnchoice;
    ArrayList<String>choice = new ArrayList<String>();
    String[]mid = {"히어로즈", "24시", "로스트", "스몰빌", "탐정몽크", "셜록",
    "빅뱅이론", "테이큰", "가십걸", "창궐", "킹덤", "신세계", "암수살인", "기생충"};
    //ArrayAdapter<String> ar;
    ArrayAdapter<String> ar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("심이진");
        btnchoice=findViewById(R.id.btnChoice);
        listView = findViewById(R.id.listView);
        //ar = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mid);
        ar = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice, mid);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(ar);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i]+"를 선택", Toast.LENGTH_SHORT).show();
            }
        });

        btnchoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice.clear();

                SparseBooleanArray checkItems = listView.getCheckedItemPositions();
                if(checkItems.size()!=0){
                    for(int i=0; i<mid.length; i++){
                        if(checkItems.get(i)){
                            choice.add(mid[i]);
                        }
                    }
                }
                String str = "";
                for(String s:choice){
                    str += s + " ";
                }
                Toast.makeText(getApplicationContext(), str + "을 선택", Toast.LENGTH_LONG).show();
            }
        });
    }
}
