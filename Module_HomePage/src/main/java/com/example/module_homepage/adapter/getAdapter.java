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

public class getAdapter extends RecyclerView.Adapter<getAdapter.viewmodel> {
    private List<get>mList;

    public getAdapter(Context context,List<get>mList) {
        mContext = context;
        this.mList = mList;
    }

    private Context mContext;
    @NonNull
    @Override
    public getAdapter.viewmodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewmodel(LayoutInflater.from(parent.getContext()).inflate(R.layout.getlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull getAdapter.viewmodel holder, int position) {
        holder.GIDTO.setText(mList.get(position).GIDTO);
        holder.GiDTO.setText(mList.get(position).GiDTO);
        holder.Menu.setText(mList.get(position).menu);
        holder.Name.setText(mList.get(position).name);
        holder.Grade.setText(mList.get(position).grade);
        holder.Suggets.setText(mList.get(position).suggets);
        holder.Tips.setText(mList.get(position).tips);
        holder.Calory.setText(mList.get(position).calory);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class viewmodel extends RecyclerView.ViewHolder {
        TextView GIDTO;
        TextView GiDTO;
        TextView Name;
        TextView Calory;
        TextView Tips;
        TextView Suggets;
        TextView Grade;
        TextView Menu;
        public viewmodel(@NonNull View itemView) {
            super(itemView);
            GIDTO = itemView.findViewById(R.id.GIDTO);
            GiDTO = itemView.findViewById(R.id.GiDTO);
            Name = itemView.findViewById(R.id.itsname);
            Calory = itemView.findViewById(R.id.itscalory);
            Tips = itemView.findViewById(R.id.healthTips);
            Suggets = itemView.findViewById(R.id.healthSuggest);
            Grade = itemView.findViewById(R.id.grade);
            Menu = itemView.findViewById(R.id.menu);
        }
    }
}
