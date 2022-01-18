package com.cookandroid.a07251;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edt;
    Button btn;
    String filename;
    File myDir;
    String strSDpath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("심이진");
        dp=findViewById(R.id.date1);
        edt=findViewById(R.id.edt1);
        btn=findViewById(R.id.btn1);
        Calendar cal = Calendar.getInstance();
        int cyear = cal.get(Calendar.YEAR);
        int cmonth = cal.get(Calendar.MONTH);
        int cday = cal.get(Calendar.DAY_OF_MONTH);
        strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        strSDpath+="/myDiary/";
        myDir=new File(strSDpath);
        if(!myDir.isDirectory()) myDir.mkdir();

        filename=Integer.toString(cyear)+"_" +Integer.toString(cmonth)+"_"+Integer.toString(cday)+".txt";
        String str = readDiary(strSDpath+filename);
        edt.setText(str);
        btn.setEnabled(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outFs = openFileOutput(filename, Context.MODE_PRIVATE);
                    String str = edt.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), filename+"이 저장됨", Toast.LENGTH_SHORT).show();
                }catch (IOException e){ }
            }
        });

        dp.init(cyear, cmonth, cday, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int mmonth, int dday) {
                filename = Integer.toString(year)+"_"+Integer.toString(mmonth+1)+"_"+ Integer.toString(dday) + ".txt";
                String str = readDiary(strSDpath+filename);
                edt.setText(str);
                btn.setEnabled(true);
            }
        });
    }
    String readDiary(String fname){
        String diaryStr = null;
        FileInputStream inFs;
        try{
            inFs = openFileInput(fname);
            byte[]txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btn.setText("수정하기");
        }catch (IOException e){
            edt.setHint("일기 없음");
            btn.setText("새로 저장");
        }
        return diaryStr;
    }
}
