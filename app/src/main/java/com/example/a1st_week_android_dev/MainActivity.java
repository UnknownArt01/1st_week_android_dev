package com.example.a1st_week_android_dev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Model.Data_user;
import Model.array_data;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_recyclerView;
    private FloatingActionButton main_floatingActionButton;
    public static ArrayList<Data_user> data_user;

    private data_RV_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        initView();
        data_insert();
        setupRecyclerView();
        clickListener();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent array_data) {
//        super.onActivityResult(requestCode, resultCode, array_data);
//
//        if (requestCode == 9988){
//            if (resultCode == 7788){
//                Data_user data_baru = array_data.getParcelableExtra("array_data-baru");
//                data_user.add(data_baru);
//                adapter.notifyDataSetChanged();
//            }
//        }
//    }
    private void data_insert(){
        Intent intent = getIntent();
        Data_user data_baru = intent.getParcelableExtra("array_data-baru");

        int title = intent.getIntExtra("title", 1);

        if(data_baru != null){
            if(title == 1){
                data_user.add(data_baru);
                adapter.notifyDataSetChanged();
            }else{
                int index2 = intent.getIntExtra("index", -1);
                data_user.set(index2, data_baru);
                adapter.notifyDataSetChanged();
            }

        }

    }
    private void clickListener(){
        main_floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), input_data.class);
                intent.putExtra("title",1);
                startActivity(intent);

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
        data_user = array_data.array;
        adapter = new data_RV_Adapter(data_user);
    }
}