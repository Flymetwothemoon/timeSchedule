package Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.module_mine.R;

import java.util.List;

public class competitionAdapter extends RecyclerView.Adapter<competitionAdapter.ViewHolder> {
    public competitionAdapter(List<competition> list,Context mContext) {
        mList = list;
        this.mContext = mContext;
    }
    private List<competition>mList;
    private Context mContext;
    public void setOnItemClickListener(mineAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private mineAdapter.OnItemClickListener mOnItemClickListener;
    @NonNull
    @Override
    public competitionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.competition_reccler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull competitionAdapter.ViewHolder holder, int position) {
    holder.intro.setText(mList.get(position).getIntro());
    holder.image.setImageResource(mList.get(position).getImage());
    holder.title.setText(mList.get(position).getTitle());
    holder.easy.setText(mList.get(position).getEasy());
        Typeface customFont = Typeface.createFromAsset(mContext.getAssets(), "TsangerYuYangT_W03_W03.ttf");
        Typeface customFont_1 = Typeface.createFromAsset(mContext.getAssets(),"Alimama_ShuHeiTi_Bold.ttf");
        Typeface customFont_2  = Typeface.createFromAsset(mContext.getAssets(),"zcool-gdh_Regular.ttf");
        holder.intro.setTypeface(customFont);
        holder.title.setTypeface(customFont_1);
        holder.easy.setTypeface(customFont_2);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mOnItemClickListener!=null) {
                int position = holder.getLayoutPosition();
                mOnItemClickListener.onItemClick(v,position);
            }

        }
    });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public interface onClick{
        void onItemClick(View view,int position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        TextView intro;
        TextView easy;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.picture);
            intro = itemView.findViewById(R.id.bottom_textView);
            easy = itemView.findViewById(R.id.easy);
        }
    }
}
