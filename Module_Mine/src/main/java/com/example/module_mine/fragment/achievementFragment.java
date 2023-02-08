package com.example.module_mine.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.module_mine.Activity.Rule_Activity;
import com.example.module_mine.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link achievementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class achievementFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView achievement;
    private View view;
    private TextView award_0text;
    private TextView award_1_text;
    private TextView award_2_text;
    private TextView rule;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public achievementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment achievementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static achievementFragment newInstance(String param1, String param2) {
        achievementFragment fragment = new achievementFragment();
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
        if(view==null) {
            view = inflater.inflate(R.layout.fragment_achievement, container, false);
        }
        init();
        return view;
    }
    private void init(){
        achievement = view.findViewById(R.id.achievement);
        award_0text = view.findViewById(R.id.award_0_text);
        award_1_text = view.findViewById(R.id.award_1_text);
        award_2_text = view.findViewById(R.id.award_2_text);
        rule = view.findViewById(R.id.rule);
        Typeface customFont1 = Typeface.createFromAsset(getActivity().getAssets(),"zcool-gdh_Regular.ttf");
        achievement.setTypeface(customFont1);
        rule.setTypeface(customFont1);
        Typeface customFont = Typeface.createFromAsset(getActivity().getAssets(),"TsangerYuYangT_W03_W03.ttf");
        award_0text.setTypeface(customFont);
        award_1_text.setTypeface(customFont);
        award_2_text.setTypeface(customFont);
        rule.setOnClickListener(this);
        rule.setTextColor(0xff000000);
    }

    @Override
    public void onClick(View v) {
        rule.setTextColor(0xffffffff);
        Intent intent = new Intent(getActivity(), Rule_Activity.class);
        startActivity(intent);
    }
}