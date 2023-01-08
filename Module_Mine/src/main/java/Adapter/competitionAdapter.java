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

public class competitionAdapter extends RecyclerView.Adapter<competitionAdapter.ViewHolder> {
    public competitionAdapter(List<competition> list) {
        mList = list;
    }
    private List<competition>mList;
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
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        TextView intro;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.picture);
            intro = itemView.findViewById(R.id.bottom_textView);
        }
    }
}
