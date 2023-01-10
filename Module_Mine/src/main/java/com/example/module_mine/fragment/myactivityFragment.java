package com.example.module_mine.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_mine.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link myactivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class myactivityFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    public myactivityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment myactivityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static myactivityFragment newInstance(String param1, String param2) {
        myactivityFragment fragment = new myactivityFragment();
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
        if(view ==null){
            view =inflater.inflate(R.layout.fragment_myactivity, container, false);
        }
        TextView activity_title = view.findViewById(R.id.activity_title);
        Utils.style.changeStyle_1(getActivity(),activity_title);
        init();

        return view;
    }
    private void init(){
        SharedPreferences pre = getActivity().getSharedPreferences("data",MODE_PRIVATE);
        if(pre.getInt("competition",0)==1){
            TextView activity_one = view.findViewById(R.id.activity_one);
            ImageView activity_one_image = view.findViewById(R.id.activity_one_image);
            activity_one.setText("7日1000步挑战");
            activity_one_image.setImageResource(R.mipmap.one);
            Utils.style.changeStyle_1(getActivity(),activity_one);
        }
        if(pre.getInt("competition_1",1)==0){
            TextView activity_two = view.findViewById(R.id.activity_two);
            ImageView activity_two_image = view.findViewById(R.id.activity_two_image);
            activity_two.setText("7日1500步挑战");
            activity_two_image.setImageResource(R.mipmap.two);
            Utils.style.changeStyle_1(getActivity(),activity_two);
        }
        if(pre.getInt("competition_2",0)==1){
            TextView activity_three = view.findViewById(R.id.activity_three);
            ImageView activity_three_image = view.findViewById(R.id.activity_three_image);
            activity_three.setText("7日3000步挑战");
            activity_three_image.setImageResource(R.mipmap.three);
            Utils.style.changeStyle_1(getActivity(),activity_three);
        }
        if(pre.getInt("competition_3",0)==1){
            TextView activity_four = view.findViewById(R.id.activity_four);
            ImageView activity_four_image = view.findViewById(R.id.activity_four_image);
            activity_four.setText("7日5000步挑战");
            activity_four_image.setImageResource(R.mipmap.four);
            Utils.style.changeStyle_1(getActivity(),activity_four);
        }
        if(pre.getInt("competition_4",0)==1){
            TextView activity_five = view.findViewById(R.id.activity_five);
            ImageView activity_five_image = view.findViewById(R.id.activity_five_image);
            activity_five.setText("7日7500步挑战");
            activity_five_image.setImageResource(R.mipmap.five);
            Utils.style.changeStyle_1(getActivity(),activity_five);
        }
        if(pre.getInt("competition_5",0)==1){
            TextView activity_six = view.findViewById(R.id.activity_six);
            ImageView activity_six_image = view.findViewById(R.id.activity_six_image);
            activity_six.setText("7日10000步挑战");
            activity_six_image.setImageResource(R.mipmap.six);
            Utils.style.changeStyle_1(getActivity(),activity_six);
        }
    }
}