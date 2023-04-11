package com.example.module_homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_homepage.R;

import java.util.List;

public class dietAdapter extends RecyclerView.Adapter<dietAdapter.viewmodel> {
    public dietAdapter(Context context,List<diet>mList) {
        mContext = context;
        this.mList = mList;
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private dietAdapter.OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(dietAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
    Context mContext;
    List<diet>mList;
    @NonNull
    @Override
    public dietAdapter.viewmodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewmodel(LayoutInflater.from(parent.getContext()).inflate(R.layout.mydietrecycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull dietAdapter.viewmodel holder, int position) {
        holder.calory.setText(mList.get(position).calory);
        holder.name.setText(mList.get(position).name);
        holder.level.setText(mList.get(position).healthLevel);
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
        TextView name;
        TextView level;
        TextView calory;
        public viewmodel(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.dietName);
            level = itemView.findViewById(R.id.dietLevel);
            calory = itemView.findViewById(R.id.dielory);
        }
    }
}
