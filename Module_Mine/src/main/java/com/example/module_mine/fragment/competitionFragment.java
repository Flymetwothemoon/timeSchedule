package com.example.module_mine.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.module_mine.Activity.Competition_Activity;
import com.example.module_mine.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.competition;
import Adapter.competitionAdapter;
import Adapter.mineAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link competitionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class competitionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private RecyclerView mRecyclerView;
    private List<competition>mList = new ArrayList<>();
    public competitionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment competitionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static competitionFragment newInstance(String param1, String param2) {
        competitionFragment fragment = new competitionFragment();
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
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_competition, container, false);
        }
        init();
        return view;
    }
    private void init(){
        mRecyclerView = view.findViewById(R.id.competition_recycler);
        competitionAdapter adapter = new competitionAdapter(mList,getContext());
        init_0();
        adapter.setOnItemClickListener(new mineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), Competition_Activity.class);
                String a;
                if(position==0){
                   a = "1000";
                  intent.putExtra("fang",a);
              }
              else if(position==1){
                     a = "1500";
                     intent.putExtra("fang",a);
              }
              else if(position==2){
                    a = "3000";
                    intent.putExtra("fang",a);
                }
              else if(position ==3){
                  a = "5000";
                  intent.putExtra("fang",a);
                }
              else if(position ==4){
                  a = "7500";
                  intent.putExtra("fang",a);
                }
              else{
                  a = "10000";
                  intent.putExtra("fang",a);
                }
              startActivity(intent);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
    }
    private void init_0(){
        competition competition = new competition();
        competition.title = "7???1000?????????";
        competition.intro ="??????7?????????????????????1000?????????????????????";
        competition.image = R.mipmap.one;
        competition.easy = "????????????";
        mList.add(competition);
        competition competition1 = new competition();
        competition1.title = "7???1500?????????";
        competition1.intro = "??????7?????????????????????1500?????????????????????";
        competition1.image = R.mipmap.two;
        competition1.easy = "????????????";
        mList.add(competition1);
        competition competition2 = new competition();
        competition2.title = "7???3000?????????";
        competition2.intro = "??????7?????????????????????3000?????????????????????";
        competition2.image = R.mipmap.three;
        competition2.easy = "????????????";
        mList.add(competition2);
        competition competition3 = new competition();
        competition3.title = "7???5000?????????";
        competition3.intro = "??????7?????????????????????5000?????????????????????";
        competition3.image = R.mipmap.four;
        competition3.easy = "????????????";
        mList.add(competition3);
        competition competition4 = new competition();
        competition4.intro = "??????7?????????????????????7500?????????????????????";
        competition4.title  ="7???7500?????????";
        competition4.image = R.mipmap.five;
        competition4.easy = "????????????";
        mList.add(competition4);
        competition competition5 = new competition();
        competition5.image  =R.mipmap.six;
        competition5.intro = "??????7?????????????????????10000?????????????????????";
        competition5.title = "7???10000?????????";
        competition5.easy = "????????????";
        mList.add(competition5);

    }
}