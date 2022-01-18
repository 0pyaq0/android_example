package com.cookandroid.a0721grid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login, cancel;
    EditText id, pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("심이진");
        login = (Button)findViewById(R.id.login);
        cancel = (Button)findViewById(R.id.cancel);
        id = (EditText)findViewById(R.id.id);
        pw = (EditText)findViewById(R.id.pw);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                String p = "아이디 : " + id.getText().toString();
                p = p + "비밀번호 : " + pw.getText().toString();
                dlg.setTitle("로그인 정보");
                dlg.setMessage(p);
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "확인 누름", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               id.setText(null);
            }
        });



    }
}
