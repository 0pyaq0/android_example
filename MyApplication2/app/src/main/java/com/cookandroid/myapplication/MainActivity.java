package com.cookandroid.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn, btnDlg1, btnDlgList,btnDlgRadio,btnDlgCk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("심이진 (Toast & Dlg Test)");
        btn = (Button)findViewById(R.id.btn);
        btnDlg1 = (Button)findViewById(R.id.btnDlg1);
        btnDlgList = (Button)findViewById(R.id.btnDlgList);
        btnDlgRadio = (Button)findViewById(R.id.btnDlgRadio);
        btnDlgCk = (Button)findViewById(R.id.btnDlgCk);

        btnDlgCk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] song = new String[]{"지젤깅", "제노깅", "윈터깅"};
                final boolean[] chkSong = new boolean[]{true, false, true};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 가수는?");
                dlg.setMultiChoiceItems(song, chkSong, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        chkSong[i] = b;
                        String out="체크된 내용";
                        for(int ind = 0; ind <song.length; ind++){
                            if(chkSong[ind]==true){
                                out = out + " " + song[ind];
                            }
                        }
                        if(out.equals("")) Toast.makeText(getApplicationContext(), "선택된 것이 아무것도 없습니다.", Toast.LENGTH_LONG).show();
                        else Toast.makeText(getApplicationContext(), "체크된 내용 : " +out, Toast.LENGTH_LONG).show();
                    }
                });

                dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "닫기를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
        btnDlgList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] song = new String[]{"지젤깅", "제노깅", "윈터깅"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 가수는?");
                dlg.setItems(song, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "선택 가수 : " + song[i], Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "닫기를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();

            }
        });

        btnDlgRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] song = new String[]{"지젤깅", "제노깅", "윈터깅"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 가수는?");
                dlg.setSingleChoiceItems(song, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "선택 가수 : " + song[i], Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "닫기를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast tMsg = Toast.makeText(MainActivity.this, "토스트 연습", Toast.LENGTH_SHORT);

                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOFFset = (int)(Math.random()*display.getWidth());
                int yOFFset = (int)(Math.random()*display.getHeight());

                tMsg.setGravity(Gravity.TOP|Gravity.LEFT,xOFFset,yOFFset);
                tMsg.show();
            }
        });

        btnDlg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목입니다");
                dlg.setMessage("[심이진] 내용입니다");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });
    }
}
