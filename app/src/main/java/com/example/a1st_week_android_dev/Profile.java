package com.example.a1st_week_android_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private TextView Name_Profile_textView, Age_Profile_textView, Address_Profile_textView;
    private Button button_edit2, button_delete;
    private ImageButton imageButton2_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();

        init_profile();
        show();
        listener();


    }
    public void show(){
        Intent intent = getIntent();
        Name_Profile_textView.setText(intent.getStringExtra("Name"));
        Age_Profile_textView.setText(intent.getStringExtra("Age"));
        Address_Profile_textView.setText(intent.getStringExtra("Address"));
    }
    public void listener(){
        button_edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), input_data.class);
                intent.putExtra("name",intent.getStringExtra("Name"));
                intent.putExtra("age",intent.getStringExtra("Age"));
                intent.putExtra("address",intent.getStringExtra("Address"));
                intent.putExtra("title","edituser");
                startActivity(intent);
            }
        });
        imageButton2_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void init_profile(){
        Name_Profile_textView = findViewById(R.id.Name_Profile_textView);
        Age_Profile_textView = findViewById(R.id.Age_Profile_textView);
        Address_Profile_textView = findViewById(R.id.Address_Profile_textView);
        button_edit2 = findViewById(R.id.button_edit2);
        button_delete = findViewById(R.id.button_delete);
        imageButton2_back = findViewById(R.id.imageButton2_back);
    }
}