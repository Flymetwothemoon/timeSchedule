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
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    @NonNull
    @Override
    public mineAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull mineAdapter.viewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).getSomething());
        holder.mImageView.setImageResource(mList.get(position).getImage());
        if(mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView, position); // 2
                }
            });
        }
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
