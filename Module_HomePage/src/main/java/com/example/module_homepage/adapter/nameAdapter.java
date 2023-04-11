package com.example.module_homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_homepage.R;

import java.util.List;

public class nameAdapter extends RecyclerView.Adapter<nameAdapter.viewmodel> {
    public nameAdapter(List<name> list,Context mContext) {
        mList = list;
        this.mContext = mContext;
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private nameAdapter.OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(nameAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
    Context mContext;
    List<name>mList;
    @NonNull
    @Override
    public nameAdapter.viewmodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewmodel(LayoutInflater.from(parent.getContext()).inflate(R.layout.namerecycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull nameAdapter.viewmodel holder, int position) {
        holder.nameText.setText(mList.get(position).name);
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
        TextView nameText;
        public viewmodel(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameText);
        }
    }
}
