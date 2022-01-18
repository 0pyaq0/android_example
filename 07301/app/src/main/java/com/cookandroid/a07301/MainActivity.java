package com.cookandroid.a07301;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    CustomAdapter customAdapter;
    Car[] carArray = {
            new Car(R.drawable.car1, "SM3"),
            new Car(R.drawable.car2, "SM4"),
            new Car(R.drawable.car3, "SM5"),
            new Car(R.drawable.car4, "SM6"),
            new Car(R.drawable.car5, "SM7"),
            new Car(R.drawable.car6, "SM8")
    };

    public void customToast(Car clickItem){
        View layout = getLayoutInflater().inflate(R.layout.car_toast_layout, null);
        ImageView image = (ImageView)layout.findViewById(R.id.imageView1);
        TextView text = (TextView)layout.findViewById(R.id.textView1);
        image.setImageResource(clickItem.getImage_id());
        text.setText(clickItem.getName());
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView)findViewById(R.id.listView);
        customAdapter = new CustomAdapter(this, carArray);
        listView1.setAdapter(customAdapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int arg2, long arg3) {
                Car clickItem = (Car)listView1.getItemAtPosition(arg2);
                setTitle(clickItem.getName());
                customToast(clickItem);
            }
        });
    }
}
