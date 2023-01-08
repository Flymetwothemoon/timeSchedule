package com.example.module_mine.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        competitionAdapter adapter = new competitionAdapter(mList);
        init_0();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
    }
    private void init_0(){
        competition competition = new competition();
        competition.title = "7日1000步运动";
        competition.intro ="连续7日每天都能运动1000步则能取得胜利";
        competition.image = R.mipmap.one;
        mList.add(competition);
        competition competition1 = new competition();
        competition1.title = "7日1500步运动";
        competition1.intro = "连续7日每天都能运动1500步则能取得胜利";
        competition1.image = R.mipmap.two;
        mList.add(competition1);
        competition competition2 = new competition();
        competition2.title = "7日3000步运动";
        competition2.intro = "连续7日每日都能运动3000步则能取得胜利";
        competition2.image = R.mipmap.three;
        mList.add(competition2);
        competition competition3 = new competition();
        competition3.title = "7日5000步运动";
        competition3.intro = "连续7日每日都能运动5000步则能取得胜利";
        competition3.image = R.mipmap.four;
        mList.add(competition3);
        competition competition4 = new competition();
        competition4.intro = "连续7日每日都能运动7500步则能取得胜利";
        competition4.title  ="7日7500步运动";
        competition4.image = R.mipmap.five;
        mList.add(competition4);
        competition competition5 = new competition();
        competition5.image  =R.mipmap.six;
        competition5.intro = "连续7日每日都能运动10000步则能取得胜利";
        competition5.title = "7日10000步运动";
        mList.add(competition5);

    }
}