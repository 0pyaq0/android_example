package com.cookandroid.a0720check;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textResult;
    CheckBox[] chkList = new CheckBox[3];
    Integer [] chktext = {R.id.gra, R.id.ki, R.id.ja};
    boolean [] ch = {true, false, true};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("체크박스실습[심이진]");
        for(int i=0; i< chkList.length; i++)chkList [i]=findViewById(chktext[i]);
        textResult = (TextView)findViewById(R.id.textResult);

        for(int i=0; i<chkList .length; i++){
            final int k=i;
            chkList [i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b)ch[k]=true;
                    else ch[k]=false;
                    textResult();
                }
            });
        }
        textResult();
    }
    public void textResult(){
        String str = "선텍 결과 : ";
        for(int i=0; i<chkList.length; i++){
            if(ch[i])str=str+" " +chkList[i].getText().toString();
        }
        textResult.setText(str);
    }
}
