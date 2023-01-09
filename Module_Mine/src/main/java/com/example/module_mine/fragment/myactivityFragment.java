package com.example.module_mine.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        init();
        return view;
    }
    private void init(){
        SharedPreferences pre = getActivity().getSharedPreferences("data_0",MODE_PRIVATE);
        if(pre.getString("competition",null).equals("1000")){
            Toast.makeText(getActivity(),"要跑10000",Toast.LENGTH_SHORT).show();
        }
    }
}