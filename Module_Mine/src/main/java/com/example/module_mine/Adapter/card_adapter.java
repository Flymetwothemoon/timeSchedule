package com.example.module_mine.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_mine.R;

import java.util.List;

public class card_adapter extends RecyclerView.Adapter<card_adapter.viewHolder> {
    public card_adapter(List<card> list) {
        mList = list;
    }
    private List<card>mList;
    @NonNull
    @Override
    public card_adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull card_adapter.viewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).textView);
        holder.mImageView.setImageResource(mList.get(position).image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_item);
            mTextView = itemView.findViewById(R.id.textview_item);
        }
    }
}
