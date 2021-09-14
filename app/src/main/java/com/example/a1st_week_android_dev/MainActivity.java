package com.example.a1st_week_android_dev;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Model.Data_user;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_recyclerView;
    private FloatingActionButton main_floatingActionButton;
    private ArrayList<Data_user> data_user;
    private data_RV_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        initView();
        setupRecyclerView();

        clickListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 9988){
            if (resultCode == 7788){
                Data_user data_baru = data.getParcelableExtra("data-baru");
                data_user.add(data_baru);
                adapter.notifyDataSetChanged();
            }
        }
    }
    private void clickListener(){
        main_floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), input_data.class);
                intent.putExtra("title","adduser");
                startActivityForResult(intent, 9988);
            }
        });
    }
    private void setupRecyclerView(){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        main_recyclerView.setLayoutManager(manager);
        main_recyclerView.setAdapter(adapter);
    }
    private void initView(){
        main_recyclerView = findViewById(R.id.main_recyclerView);
        main_floatingActionButton = findViewById(R.id.main_floatingActionButton);
        data_user = new ArrayList<Data_user>();
        adapter = new data_RV_Adapter(data_user);
    }
}