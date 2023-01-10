package com.example.module_mine.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.module_mine.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link One_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class One_Fragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private TextView judge_0;
    public One_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment One_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static One_Fragment newInstance(String param1, String param2) {
        One_Fragment fragment = new One_Fragment();
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
        if(view ==null) {
            view = inflater.inflate(R.layout.fragment_one_, container, false);
        }
        init();
        return view;
    }
    private void init(){
        TextView title = view.findViewById(R.id.title);
        TextView easy = view.findViewById(R.id.easy);
        Button button = view.findViewById(R.id.button);
        judge_0 = view.findViewById(R.id.judge);
        Utils.style.changeStyle_1(view.getContext(),title);
        Utils.style.changeStyle_2(view.getContext(),easy);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        if(sharedPreferences.getInt("competition_5",0)==1){
            judge_0.setText("你已接受了此挑战");
        }
        else {
            button.setOnClickListener(this);
            judge();
        }
        Utils.style.changeStyle_0(view.getContext(),judge_0);
    }
    private void judge(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        if(sharedPreferences.getInt("competition_5",0)==1){
            judge_0.setText("你已接受了此挑战");
        }
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putInt("competition_5",1);
        editor.commit();
        Toast.makeText(getActivity(),"接受挑战",Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }
}