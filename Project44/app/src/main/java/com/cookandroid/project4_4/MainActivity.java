package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.project4_4.R;

public class MainActivity extends AppCompatActivity {
    TextView txtAnimal;
    Switch swiAgree;
    RadioGroup rdoGroup;
    RadioButton rdo8, rdo9, rdo10;
    Button btnEnd, btnBack;
    ImageView imgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("심이진");
        txtAnimal=(TextView)findViewById(R.id.txtAnimal);
        swiAgree=(Switch)findViewById(R.id.swiAgree);
        rdoGroup=(RadioGroup)findViewById((R.id.rdoGroup));
        rdo8=(RadioButton)findViewById((R.id.rdo8));
        rdo9=(RadioButton)findViewById((R.id.rdo9));
        rdo10=(RadioButton)findViewById((R.id.rdo10));
        btnBack=(Button)findViewById(R.id.btnBack);
        btnEnd=(Button)findViewById(R.id.btnEnd);
        imgPet=(ImageView)findViewById((R.id.imgPet));

        swiAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(swiAgree.isChecked()==true){
                    txtAnimal.setVisibility(View.VISIBLE);
                    rdoGroup.setVisibility(View.VISIBLE);
                    btnBack.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }else{
                    txtAnimal.setVisibility(View.INVISIBLE);
                    rdoGroup.setVisibility(View.INVISIBLE);
                    btnBack.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rdoGroup.getCheckedRadioButtonId()){
                    case R.id.rdo8:
                        imgPet.setImageResource(R.drawable.dog2); break;

                    case R.id.rdo9:
                        imgPet.setImageResource(R.drawable.cat); break;

                    case R.id.rdo10:
                        imgPet.setImageResource(R.drawable.rabbit); break;

                    default:
                        Toast.makeText(getApplicationContext(), "먼저 동물을 선택해주세요", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rdoDog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rdoDog.isChecked()==true){
                    imgPet.setImageResource(R.drawable.dog2);
                }
            }
        });

        rdoCat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rdoCat.isChecked()==true){
                    imgPet.setImageResource(R.drawable.cat);
                }
            }
        });

        rdoRabbit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rdoRabbit.isChecked()==true){
                    imgPet.setImageResource(R.drawable.rabbit);
                }
            }
        });
    }
}