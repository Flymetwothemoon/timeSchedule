package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_mine.R;

import java.util.List;

public class mineAdapter extends RecyclerView.Adapter<mineAdapter.viewHolder> {
    public mineAdapter(List<mine> list) {
        mList = list;
    }
    private List<mine>mList;
    @NonNull
    @Override
    public mineAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull mineAdapter.viewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).getSomething());
        holder.mImageView.setImageResource(mList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.mine_text);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }
}
