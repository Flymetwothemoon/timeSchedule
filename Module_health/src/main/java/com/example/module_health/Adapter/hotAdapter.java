package com.example.module_health.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_health.R;

import java.util.List;

public class hotAdapter extends RecyclerView.Adapter<hotAdapter.ViewModel> {
    public hotAdapter(List<hot> list,Context context) {
        mList = list;
        mContext = context;
    }
    Context mContext;
    List<hot>mList;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private hotAdapter.OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(hotAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
    @NonNull
    @Override
    public hotAdapter.ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewModel(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull hotAdapter.ViewModel holder, int position) {
        holder.mTextView.setText(mList.get(position).text);
        holder.mImageView.setImageResource(mList.get(position).image);
        Typeface customFont = Typeface.createFromAsset(mContext.getAssets(), "TsangerYuYangT_W03_W03.ttf");
        Typeface customFont_1 = Typeface.createFromAsset(mContext.getAssets(),"Alimama_ShuHeiTi_Bold.ttf");
        Typeface customFont_2  = Typeface.createFromAsset(mContext.getAssets(),"zcool-gdh_Regular.ttf");
        holder.mTextView.setTypeface(customFont);
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

    public class ViewModel extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.test_image);
            mTextView = itemView.findViewById(R.id.test_text);
        }
    }
}
