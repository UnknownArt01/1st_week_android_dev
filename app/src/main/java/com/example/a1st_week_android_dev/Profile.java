package com.example.a1st_week_android_dev;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Model.Data_user;
import Model.Loading;
import Model.array_data;

public class Profile extends AppCompatActivity {
    private TextView Name_Profile_textView, Age_Profile_textView, Address_Profile_textView;
    private Button button_edit2, button_delete;
    private ImageButton imageButton2_back;
    private String nama, age, address;
    public static ArrayList<Data_user> data_profile = array_data.array;
    private Loading loading = new Loading(Profile.this);
    int number;

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
        Data_user data_baru = intent.getParcelableExtra("array_data-show");

        Name_Profile_textView.setText(data_baru.getNama());
        Age_Profile_textView.setText(data_baru.getUmur());
        Address_Profile_textView.setText(data_baru.getAlamat());

         nama = data_baru.getNama();
         age = data_baru.getUmur();
         address = data_baru.getAlamat();
         number = intent.getIntExtra("index",-1);


    }
    public void listener(){
        button_edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), input_data.class);
                intent.putExtra("name",nama);
                intent.putExtra("age",age);
                intent.putExtra("address",address);
                intent.putExtra("index", number);
                intent.putExtra("title",2);

                startActivity(intent);
            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            AlertDialog ad = new AlertDialog.Builder(Profile.this)
                    .setTitle("Confirm").setMessage("Are You Sure Want To Delete This Data?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getBaseContext(), MainActivity.class);
                            data_profile.remove(number);
                            startActivity(intent);

                            loading.startLoadingDialog();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    loading.dismiss();
                                    finish();
                                }
                            }, 500);
                            Toast.makeText(getApplicationContext(), "Data DELETED!", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create();
            ad.show();

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