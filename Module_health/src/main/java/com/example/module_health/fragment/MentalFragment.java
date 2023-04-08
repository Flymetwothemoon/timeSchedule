package com.example.module_health.fragment;

import static Utils.changeTextStyle.change;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.module_health.Activity.HeartHealthActivity;
import com.example.module_health.Activity.powerActivity;
import com.example.module_health.Activity.sadActivity;
import com.example.module_health.Adapter.daily;
import com.example.module_health.Adapter.dailyAdapter;
import com.example.module_health.Adapter.hot;
import com.example.module_health.Adapter.hotAdapter;
import com.example.module_health.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MentalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MentalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;

    private TextView daily_choose;
    private TextView hot;
    private RecyclerView test_recycler;
    private List<daily>mList = new ArrayList<>();
    private List<hot>mList1 = new ArrayList<>();
    public MentalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MentalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MentalFragment newInstance(String param1, String param2) {
        MentalFragment fragment = new MentalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view==null){
            view = inflater.inflate(R.layout.fragment_mental, container, false);
        }
        init();

        return view;
    }
    private void init(){
        daily_choose = view.findViewById(R.id.daily_choose);
        hot = view.findViewById(R.id.hot);

        change(daily_choose,getActivity());
        change(hot,getContext());

        test_recycler = view.findViewById(R.id.test_recycler);

        init_test();
        dailyAdapter adapter = new dailyAdapter(mList);
        LinearLayoutManager m=new LinearLayoutManager(getContext());
        m.setOrientation(LinearLayoutManager.HORIZONTAL);

        hotAdapter hotAdapter = new hotAdapter(mList1,getContext());
        test_recycler.setAdapter(hotAdapter);
        test_recycler.setLayoutManager(new LinearLayoutManager(getContext()));


        hotAdapter.setOnItemClickListener(new hotAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                if(position==2) {
                    intent = new Intent(getContext(), HeartHealthActivity.class);
                    startActivity(intent);
                }
                else if(position==1){
                    intent = new Intent(getContext(), powerActivity.class);
                    startActivity(intent);
                }
                else if(position==0){
                    intent = new Intent(getContext(), sadActivity.class);
                    startActivity(intent);
                }

            }
        });

        adapter.setOnItemClickListener(new dailyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }

    private void init_test() {
        hot hot = new hot();
        hot.setText("专业抑郁风险测评");
        hot.setImage(R.mipmap.ii);
        mList1.add(hot);
        hot hot1 = new hot();
        hot1.setText("吸引力综合测评");
        hot1.setImage(R.mipmap.iii);
        mList1.add(hot1);
        hot hot2 = new hot();
        hot2.setImage(R.mipmap.i);
        hot2.setText("心理健康评估");
        mList1.add(hot2);
    }


}