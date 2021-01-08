package com.example.transactionapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{

    ArrayList<model> dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {



        holder.ddate.setText(dataholder.get(position).getDate());
        holder.dparticulars.setText(dataholder.get(position).getParticulars());
        holder.dincome.setText(dataholder.get(position).getIncome());
        holder.dexpends.setText(dataholder.get(position).getExpends());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView ddate,dparticulars,dincome,dexpends;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            ddate=itemView.findViewById(R.id.display_date);
            dparticulars=itemView.findViewById(R.id.display_particulars);
            dincome=itemView.findViewById(R.id.display_income);
            dexpends=itemView.findViewById(R.id.display_expends);
        }
    }

}
