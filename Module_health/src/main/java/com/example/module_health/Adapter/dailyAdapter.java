package com.example.module_health.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_health.R;

import java.util.List;

public class dailyAdapter extends RecyclerView.Adapter<dailyAdapter.viewmodel> {
    public dailyAdapter(List<daily> list) {
        mList = list;
    }

    private List<daily>mList;
    @NonNull
    @Override
    public dailyAdapter.viewmodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewmodel(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_recycler,parent,false));
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private dailyAdapter.OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(dailyAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
    @Override
    public void onBindViewHolder(@NonNull dailyAdapter.viewmodel holder, int position) {
        holder.daily_text.setText(mList.get(position).daily_text);
        holder.daily_imag.setText(mList.get(position).daily_ima);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getLayoutPosition();
                mOnItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class viewmodel extends RecyclerView.ViewHolder {
        private TextView daily_text;
        private TextView daily_imag;
        public viewmodel(@NonNull View itemView) {
            super(itemView);
            daily_imag = itemView.findViewById(R.id.daily_ima);
            daily_text = itemView.findViewById(R.id.daily_text);
        }
    }
}
