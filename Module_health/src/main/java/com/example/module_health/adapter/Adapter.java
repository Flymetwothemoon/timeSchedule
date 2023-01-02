package com.example.module_health.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_health.R;
import com.example.module_health.bean.Data;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> {
    public Adapter(List<Data> list) {
        mList = list;
    }

    private List<Data>mList;
    @NonNull
    @Override
    public Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.time,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewholder holder, int position) {
        holder.data.setText(mList.get(position).getDay());
        holder.weekend.setText(mList.get(position).getDayOfWeekend());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView weekend;
        TextView data;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            weekend = itemView.findViewById(R.id.weekend);
            data = itemView.findViewById(R.id.data);
        }
    }
}
