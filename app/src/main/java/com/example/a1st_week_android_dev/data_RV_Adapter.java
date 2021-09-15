package com.example.a1st_week_android_dev;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Model.Data_user;

public class data_RV_Adapter extends RecyclerView.Adapter<data_RV_Adapter.MainViewHolder> {

    private ArrayList<Data_user> data_adapter = new ArrayList<>();

    public data_RV_Adapter(ArrayList<Data_user> data_adapter) {
        this.data_adapter = data_adapter;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_layout, parent, false);
        MainViewHolder holder = new MainViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(data_RV_Adapter.MainViewHolder holder, int position) {
        holder.Name_textView.setText(data_adapter.get(position).getNama());
        holder.Age_textView.setText(data_adapter.get(position).getUmur());
        holder.Address_textView.setText(data_adapter.get(position).getAlamat());

    }

    @Override
    public int getItemCount() {
        return data_adapter.size();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder{

        private TextView Name_textView, Age_textView, Address_textView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            Name_textView =itemView.findViewById(R.id.Name_textView);
            Age_textView =itemView.findViewById(R.id.Age_textView);
            Address_textView =itemView.findViewById(R.id.Address_textView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String Name = Name_textView.getText().toString().trim();
                    String Age = Age_textView.getText().toString().trim();
                    String Address = Address_textView.getText().toString().trim();

                    Intent intent = new Intent(view.getContext(),Profile.class);
                    Data_user profile = new Data_user(Name, Age, Address);
                    intent.putExtra("array_data-show", profile);
                    intent.putExtra("index", getAdapterPosition());
                    view.getContext().startActivity(intent);

                }
            });

        }

    }
}
