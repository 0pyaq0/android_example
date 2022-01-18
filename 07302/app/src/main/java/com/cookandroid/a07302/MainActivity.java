package com.cookandroid.a07302;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtGName, edtGnumber;
    TextView txtGNameResult, txtGNumberResult;
    Button btnClear, btnInsert, btnSelect, btnUpdate, btnDelete;

    MyDBHelper myDBHelper;
    SQLiteDatabase sqIDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtGName = findViewById(R.id.edtName);
        edtGnumber=findViewById(R.id.edtGNumber);
        txtGNameResult=findViewById(R.id.txtGNameResult);
        txtGNumberResult=findViewById(R.id.txtGNumberResult);
        btnClear=findViewById(R.id.btnClear);
        btnInsert=findViewById(R.id.btnInsert);
        btnSelect=findViewById(R.id.btnSelect);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);

        myDBHelper=new MyDBHelper(this);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqIDB=myDBHelper.getWritableDatabase();
                myDBHelper.onUpgrade(sqIDB, 1, 2);
                sqIDB.close();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    sqIDB=myDBHelper.getWritableDatabase();
                    String sql = "insert into groupTBL(gname, gnumber)";
                    sql+="values('"+edtGName.getText().toString()+"',";
                    sql+=edtGnumber.getText().toString()+");";
                    sqIDB.execSQL(sql);
                    sqIDB.close();
                    Toast.makeText(getApplicationContext(), "입력되었습니다.", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqIDB=myDBHelper.getWritableDatabase();
                Cursor cursor;
                cursor=sqIDB.rawQuery("select * from groupTBL;", null);
                String strNames = "그룹명"+"\n"+"_________________"+"\n";
                String strNumbers = "인원수"+"\n"+"_________________"+"\n";
                while (cursor.moveToNext()){
                    strNames+=cursor.getString(1)+"\n";
                    strNumbers+=cursor.getInt(2)+"\n";
                }
                txtGNameResult.setText(strNames);
                txtGNumberResult.setText(strNumbers);
                cursor.close();
                sqIDB.close();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.update, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 정보 수정");
                dlg.setView(v);
                final EditText edtUpdateGName = v.findViewById(R.id.edtUpdateGName);
                final EditText edtUpdateGNumber = v.findViewById(R.id.edtUpdateGNumber);
                dlg.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            sqIDB=myDBHelper.getWritableDatabase();
                            String name = edtUpdateGName.getText().toString().trim();
                            String number= edtUpdateGNumber.getText().toString().trim();
                            if(!name.isEmpty() && !number.isEmpty()){
                                String sql = "UPDATE groupTBL SET gNumber="+number+"WHERE gName = '"+name+"'";
                                sqIDB.execSQL(sql);
                                sqIDB.close();
                                Toast.makeText(getApplicationContext(), "수정됨", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(), "수정실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null); dlg.show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.delete, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 삭제");
                dlg.setView(v);
                final EditText edtUpdateGName = v.findViewById(R.id.edtUpdateGName);
                final EditText edtUpdateGNumber = v.findViewById(R.id.edtUpdateGNumber);
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            sqIDB=myDBHelper.getWritableDatabase();
                            String name = edtUpdateGName.getText().toString().trim();
                            if(!name.isEmpty()){
                                sqIDB.execSQL("DELETE FROM groupTBL WHERE gName = '"+ name +"';");
                                sqIDB.close();
                                Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            }
                            else Toast.makeText(getApplicationContext(), "이름을 입력하세요", Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(), "삭제실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null); dlg.show();
            }
        });
    }
}
