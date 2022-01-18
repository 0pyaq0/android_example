package com.cookandroid.a0721order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText [] edList = new EditText[3];
    int[]price = {25000, 15000, 10000};
    Integer[]menu={R.id.pizza, R.id.spa, R.id.sal};
    CheckBox member;
    Button mm, reset;
    TextView total, num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        member = (CheckBox)findViewById(R.id.member);
        mm = (Button)findViewById(R.id.mm);
        reset = (Button)findViewById(R.id.reset);
        total = (TextView)findViewById(R.id.total);
        num =(TextView)findViewById(R.id.total);

        for(int i=0; i<edList.length; i++){
            edList[i]=findViewById(menu[i]);
        }
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<edList.length; i++){
                    edList[i].setText("0");
                }
                total.setText("주문개수 : 0");
                num.setText("주문금액 : 0");
            }
        });
        mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0, n = 0;
                for(int i=0; i<edList.length; i++){
                    int x = Integer.parseInt(edList[i].getText().toString());
                    sum += (x*price[i]);
                    n+=x;
                }
                if(member.isChecked()==true)
                    sum = (int)(sum*0.2);
                total.setText("주문개수 : "+n);
                num.setText("주문금액 : " + sum + "원");
            }
        });
    }
}
