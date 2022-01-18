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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtAnimal;
    CheckBox chkAgree;
    RadioGroup rdoGroup;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOk, btnEnd;
    ImageView imgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("심이진");
        txtAnimal=(TextView)findViewById(R.id.txtAnimal);
        chkAgree=(CheckBox)findViewById((R.id.chkAgree));
        rdoGroup=(RadioGroup)findViewById((R.id.rdoGroup));
        rdoDog=(RadioButton)findViewById((R.id.rdoDog));
        rdoCat=(RadioButton)findViewById((R.id.rdoCat));
        rdoRabbit=(RadioButton)findViewById((R.id.rdoRabbit));
        btnOk=(Button)findViewById(R.id.btnOk);
        btnEnd=(Button)findViewById(R.id.btnEnd);
        imgPet=(ImageView)findViewById((R.id.imgPet));

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkAgree.isChecked()==true){
                    txtAnimal.setVisibility(View.VISIBLE);
                    rdoGroup.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }else{
                    txtAnimal.setVisibility(View.INVISIBLE);
                    rdoGroup.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rdoGroup.getCheckedRadioButtonId()){
                    case R.id.rdoDog:
                        imgPet.setImageResource(R.drawable.dog2); break;

                    case R.id.rdoCat:
                        imgPet.setImageResource(R.drawable.cat); break;

                    case R.id.rdoRabbit:
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