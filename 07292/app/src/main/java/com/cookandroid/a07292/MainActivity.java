package com.cookandroid.a07292;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtAdd;
    Button btnAdd, btnDelete;
    ListView list;
    ArrayList<String> midList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAdd=findViewById(R.id.edtAdd);
        btnAdd=findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        list=findViewById(R.id.listView1);

        midList=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, midList);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midList.add(edtAdd.getText().toString());
                adapter.notifyDataSetChanged();
                edtAdd.setText("");
                edtAdd.setHint("구입할 상품을 입력하세요");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray sparseBooleanArray = list.getCheckedItemPositions();
                if(sparseBooleanArray.size()!=0){
                    for(int i=list.getCount()-1; i>=0; i--){
                        if(sparseBooleanArray.get(i)){
                            midList.remove(i);
                        }
                    }
                }
                /*int pos;
                pos=list.getCheckedItemPosition();
                if(pos!=ListView.INVALID_POSITION){
                    midList.remove(pos);
                    list.clearChoices();
                    adapter.notifyDataSetChanged();
                }*/
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "선택한 항목명 : "+midList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
