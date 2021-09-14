package com.example.a1st_week_android_dev;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import Model.Data_user;
import Model.Loading;

public class input_data extends AppCompatActivity {
    private TextInputLayout Name_textInputLayout, Age_textInputLayout, Address_textInputLayout;
    private Button Pencet_button;
    private Loading loading = new Loading(input_data.this);
    private ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        setSupportActionBar();

        initView_data();
        listener();

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        if(title.equalsIgnoreCase("edituser")){
            String nama = intent.getStringExtra("name");
            Name_textInputLayout.getEditText().setText(nama);
            Age_textInputLayout.getEditText().setText(intent.getStringExtra("age"));
            Address_textInputLayout.getEditText().setText(intent.getStringExtra("address"));

        }



    }
    public void from_profile(){

    }

    private void setSupportActionBar() {
        getSupportActionBar().hide();

    }

    private void initView_data(){
        Name_textInputLayout = findViewById(R.id.Name_textInputLayout);
        Age_textInputLayout = findViewById(R.id.Age_textInputLayout);
        Address_textInputLayout = findViewById(R.id.Address_textInputLayout);
        Pencet_button = findViewById(R.id.Pencet_button);
        imageButton = findViewById(R.id.imageButton);
    }
    private void listener(){
        Pencet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = Name_textInputLayout.getEditText().getText().toString().trim();
                String Age = Age_textInputLayout.getEditText().getText().toString().trim();
                String Address = Address_textInputLayout.getEditText().getText().toString().trim();

                    Data_user data = new Data_user(Name, Age, Address);
                    Intent intent = new Intent();
                    intent.putExtra("data-baru", data);
                    setResult(7788, intent);

                    loading.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loading.dismiss();
                            finish();
                        }
                    }, 500);
                    Toast.makeText(getApplicationContext(), "Data Saved!!!", Toast.LENGTH_SHORT).show();

                }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}