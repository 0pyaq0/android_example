package com.cookandroid.a0720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    CheckBox [] chk = new CheckBox[3];
    Integer [] chklds = {R.id.gra, R.id.ki, R.id.ja};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("체크박스실습[심이진]");
        for(int i=0; i< chk.length; i++)chk[i]=findViewById(chklds[i]);
        tv = findViewById(R.id.tv);

     

       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result="";
                for(int i=0; i<chk.length; i++){
                    if(chk[i].isChecked()==true){
                        result = result + chk[i].getText().toString()+" ";
                    }
                    if(result.equals("")) tv.setText("선택하지 않았습니다.");
                    else tv.setText("선택결과 : " + result);
                }
            }
        });
*/
    }
}
