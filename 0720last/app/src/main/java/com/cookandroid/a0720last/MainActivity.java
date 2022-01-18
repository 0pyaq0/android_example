package com.cookandroid.a0720last;

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
    RadioButton rdoDog, rdoCat, rdoRabbit, rdoRabbit1;
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
        rdoRabbit1=(RadioButton)findViewById(R.id.rdoRabbit1);
        btnOk=(Button)findViewById(R.id.btnOk);
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


        rdoGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rdoGroup.getCheckedRadioButtonId()){
                    case R.id.rdoDog:
                        imgPet.setImageResource(R.drawable.api30); break;

                    case R.id.rdoCat:
                        imgPet.setImageResource(R.drawable.api44); break;

                    case R.id.rdoRabbit:
                        imgPet.setImageResource(R.drawable.pie); break;

                    case R.id.rdoRabbit1:
                        imgPet.setImageResource(R.drawable.oreo); break;
                    default:
                        Toast.makeText(getApplicationContext(), "먼저 동물을 선택해주세요", Toast.LENGTH_LONG).show();
                }
            }
        });
        
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdoGroup.clearCheck();
                imgPet.setImageDrawable(null);
            }
        });

        rdoDog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rdoDog.isChecked()==true){
                    imgPet.setImageResource(R.drawable.api30);
                }
            }
        });

        rdoCat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rdoCat.isChecked()==true){
                    imgPet.setImageResource(R.drawable.api44);
                }
            }
        });

        rdoRabbit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rdoRabbit.isChecked()==true){
                    imgPet.setImageResource(R.drawable.pie);
                }
            }
        });

        rdoRabbit1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(rdoRabbit.isChecked()==true){
                    imgPet.setImageResource(R.drawable.oreo);
                }
            }
        });
    }
}