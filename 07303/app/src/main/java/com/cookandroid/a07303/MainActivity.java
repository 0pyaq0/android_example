package com.cookandroid.a07303;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtTel;
    Button btnAdd, btnSelect;
    ListView listView;

    MyDBHelper myDBHelper;
    SQLiteDatabase sqlDB;
    ContactAdapter cAdapter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edtName);
        edtTel=findViewById(R.id.edtTel);
        btnAdd=findViewById(R.id.btnAdd);
        btnSelect=findViewById(R.id.btnSelect);
        listView=findViewById(R.id.listView);

        myDBHelper=new MyDBHelper(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    sqlDB=myDBHelper.getWritableDatabase();
                    String sql = "INSERT INTO contactDB VALUES (null, ?, ?);";
                    Object[] args = {edtName.getText().toString(), edtTel.getText().toString()};
                    sqlDB.execSQL(sql, args);
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                    edtName.setText(""); edtTel.setText("");
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myDBHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM contactDB;", null);
                if(cursor.getCount()>0){
                    cAdapter=new ContactAdapter(MainActivity.this, cursor, true);
                    listView.setAdapter(cAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회됨", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        cursor.close();
    }
}
