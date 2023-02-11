package com.example.module_homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_homepage.R;
import com.example.module_homepage.bean.banner_bean;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class banner_adapter extends BannerAdapter<banner_bean,banner_adapter.BannerHolder> {
    Context context;

    public banner_adapter(Context context ,List<banner_bean> datas) {
        super(datas);
        this.context=context;
    }


    @Override
    public BannerHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new BannerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item,parent,false));
    }

    @Override
    public void onBindView(BannerHolder holder, banner_bean data, int position, int size) {
        holder.imageView.setImageResource(data.getImageViewID());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


    public class BannerHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.banner_item_image);
        }
    }

}
