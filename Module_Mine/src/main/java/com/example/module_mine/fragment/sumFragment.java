package com.example.module_mine.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.module_mine.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sumFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    public sumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sumFragment newInstance(String param1, String param2) {
        sumFragment fragment = new sumFragment();
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
            view = inflater.inflate(R.layout.fragment_sum, container, false);
        }
        init();
        return view;
    }
    private void init(){
        TextView show = view.findViewById(R.id.show);
        TextView title = view.findViewById(R.id.text0);
        title.setText("一周小结");
        Utils.style.changeStyle_1(getActivity(),title);
        String a = sumStep();
        int b = sumCompetition();
        int c = sumSuccessfulCompetition();
        show.setText("本周共行走了"+a+"步"+"\n"+"报名了"+b+"个比赛项目\n"+"成功完成了"+c+"个比赛项目\n");

    }
    private String sumStep(){
        String a = "0";
        return a;
    }
    private int sumCompetition(){
        int b = 0;
        return b;
    }
    private int sumSuccessfulCompetition(){
        int c = 0;
        return c;
    }
}