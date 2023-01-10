package com.example.module_mine.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.util.Util;
import com.example.module_mine.Activity.Rule_0Activity;
import com.example.module_mine.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link myactivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class myactivityFragment extends Fragment implements View.OnLongClickListener, View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private ConstraintLayout constraintLayout_0;
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
        TextView rule_0 = view.findViewById(R.id.rule_0);
        Utils.style.changeStyle_1(getActivity(),rule_0);
        Utils.style.changeStyle_1(getActivity(),activity_title);
        rule_0.setOnClickListener(this);
        init();
        remove();
        return view;
    }
    private void init(){
        SharedPreferences pre = getActivity().getSharedPreferences("data",MODE_PRIVATE);
        if(pre.getInt("competition",0)==1){
            TextView activity_one = view.findViewById(R.id.activity_one);
            ImageView activity_one_image = view.findViewById(R.id.activity_one_image);
            TextView text_0 = view.findViewById(R.id.text_0);
            activity_one.setText("7日1000步挑战");
            text_0.setText("你未完成此挑战");
            activity_one_image.setImageResource(R.mipmap.one);
            Utils.style.changeStyle_0(getActivity(),text_0);
            Utils.style.changeStyle_1(getActivity(),activity_one);
        }
        if(pre.getInt("competition_1",1)==0){
            TextView activity_two = view.findViewById(R.id.activity_two);
            ImageView activity_two_image = view.findViewById(R.id.activity_two_image);
            activity_two.setText("7日1500步挑战");
            TextView text_1 = view.findViewById(R.id.text_1);
            text_1.setText("你未完成此挑战");
            Utils.style.changeStyle_0(getActivity(),text_1);
            activity_two_image.setImageResource(R.mipmap.two);
            Utils.style.changeStyle_1(getActivity(),activity_two);
        }
        if(pre.getInt("competition_2",0)==1){
            TextView activity_three = view.findViewById(R.id.activity_three);
            ImageView activity_three_image = view.findViewById(R.id.activity_three_image);
            activity_three.setText("7日3000步挑战");
            TextView text_2 = view.findViewById(R.id.text_2);
            text_2.setText("你未完成此挑战");
            Utils.style.changeStyle_0(getActivity(),text_2);
            activity_three_image.setImageResource(R.mipmap.three);
            Utils.style.changeStyle_1(getActivity(),activity_three);
        }
        if(pre.getInt("competition_3",0)==1){
            TextView activity_four = view.findViewById(R.id.activity_four);
            ImageView activity_four_image = view.findViewById(R.id.activity_four_image);
            activity_four.setText("7日5000步挑战");
            TextView text_3 = view.findViewById(R.id.text_3);
            text_3.setText("你未完成此挑战");
            Utils.style.changeStyle_0(getActivity(),text_3);
            activity_four_image.setImageResource(R.mipmap.four);
            Utils.style.changeStyle_1(getActivity(),activity_four);
        }
        if(pre.getInt("competition_4",0)==1){
            TextView activity_five = view.findViewById(R.id.activity_five);
            ImageView activity_five_image = view.findViewById(R.id.activity_five_image);
            activity_five.setText("7日7500步挑战");
            TextView text_4 = view.findViewById(R.id.text_4);
            text_4.setText("你未完成此挑战");
            Utils.style.changeStyle_0(getActivity(),text_4);
            activity_five_image.setImageResource(R.mipmap.five);
            Utils.style.changeStyle_1(getActivity(),activity_five);
        }
        if(pre.getInt("competition_5",0)==1){
            TextView activity_six = view.findViewById(R.id.activity_six);
            ImageView activity_six_image = view.findViewById(R.id.activity_six_image);
            activity_six.setText("7日10000步挑战");
            TextView text_5 = view.findViewById(R.id.text_5);
            text_5.setText("你未完成此挑战");
            Utils.style.changeStyle_0(getActivity(),text_5);
            activity_six_image.setImageResource(R.mipmap.six);
            Utils.style.changeStyle_1(getActivity(),activity_six);
        }
    }
    private void remove(){
        constraintLayout_0= view.findViewById(R.id.constraint_0);
        ConstraintLayout constraintLayout_1 = view.findViewById(R.id.constraint_1);
        ConstraintLayout constraintLayout_2 = view.findViewById(R.id.constraint_2);
        ConstraintLayout constraintLayout_3 = view.findViewById(R.id.constraint_3);
        ConstraintLayout constraintLayout_4 = view.findViewById(R.id.constraint_4);
        ConstraintLayout constraintLayout_5 = view.findViewById(R.id.constraint_5);
        constraintLayout_0.setOnLongClickListener(this);
        constraintLayout_1.setOnLongClickListener(this);
        constraintLayout_2.setOnLongClickListener(this);
        constraintLayout_3.setOnLongClickListener(this);
        constraintLayout_4.setOnLongClickListener(this);
        constraintLayout_5.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId()==R.id.constraint_0){
            new AlertDialog.Builder(getActivity()).setTitle("确定取消吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putInt("competition",0);
                    editor.commit();
                    TextView activity_one = view.findViewById(R.id.activity_one);
                    ImageView activity_one_image = view.findViewById(R.id.activity_one_image);
                    TextView text_0 = view.findViewById(R.id.text_0);
                    activity_one.setText("");
                    text_0.setText("");
                    activity_one_image.setImageResource(R.mipmap.white);
                    Toast.makeText(getActivity(),"取消成功",Toast.LENGTH_SHORT).show();
                }
            }).setNegativeButton("否",null).show();

        }
        if(v.getId()==R.id.constraint_1){
            new AlertDialog.Builder(getActivity()).setTitle("确定取消吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putInt("competition_1",1);
                    editor.commit();
                    TextView activity_two = view.findViewById(R.id.activity_two);
                    ImageView activity_two_image = view.findViewById(R.id.activity_two_image);
                    TextView text_1 = view.findViewById(R.id.text_1);
                    activity_two.setText("");
                    text_1.setText("");
                    activity_two_image.setImageResource(R.mipmap.white);
                    Toast.makeText(getActivity(),"取消成功",Toast.LENGTH_SHORT).show();
                }
            }).setNegativeButton("否",null).show();
        }
        if(v.getId()==R.id.constraint_2){
            new AlertDialog.Builder(getActivity()).setTitle("确定取消吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putInt("competition_2",0);
                    editor.commit();
                    TextView activity_three = view.findViewById(R.id.activity_three);
                    ImageView activity_three_image = view.findViewById(R.id.activity_three_image);
                    TextView text_2 = view.findViewById(R.id.text_2);
                    activity_three.setText("");
                    text_2.setText("");
                    activity_three_image.setImageResource(R.mipmap.white);
                    Toast.makeText(getActivity(),"取消成功",Toast.LENGTH_SHORT).show();
                }
            }).setNegativeButton("否",null).show();
        }
        if(v.getId()==R.id.constraint_3){
            new AlertDialog.Builder(getActivity()).setTitle("确定取消吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putInt("competition_3",0);
                    editor.commit();
                    TextView activity_four = view.findViewById(R.id.activity_four);
                    ImageView activity_four_image = view.findViewById(R.id.activity_four_image);
                    TextView text_3 = view.findViewById(R.id.text_3);
                    activity_four.setText("");
                    text_3.setText("");
                    activity_four_image.setImageResource(R.mipmap.white);
                    Toast.makeText(getActivity(),"取消成功",Toast.LENGTH_SHORT).show();
                }
            }).setNegativeButton("否",null).show();
        }
        if(v.getId()==R.id.constraint_4){
            new AlertDialog.Builder(getActivity()).setTitle("确定取消吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putInt("competition_4",0);
                    editor.commit();
                    TextView activity_five = view.findViewById(R.id.activity_five);
                    ImageView activity_five_image = view.findViewById(R.id.activity_five_image);
                    TextView text_4 = view.findViewById(R.id.text_4);
                    activity_five.setText("");
                    text_4.setText("");
                    activity_five_image.setImageResource(R.mipmap.white);
                    Toast.makeText(getActivity(),"取消成功",Toast.LENGTH_SHORT).show();
                }
            }).setNegativeButton("否",null).show();
        }
        if(v.getId()==R.id.constraint_5){
            new AlertDialog.Builder(getActivity()).setTitle("确定取消吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putInt("competition_5",0);
                    editor.commit();
                    TextView activity_five = view.findViewById(R.id.activity_six);
                    ImageView activity_six_image = view.findViewById(R.id.activity_six_image);
                    TextView text_5 = view.findViewById(R.id.text_5);
                    activity_five.setText("");
                    text_5.setText("");
                    activity_six_image.setImageResource(R.mipmap.white);
                    Toast.makeText(getActivity(),"取消成功",Toast.LENGTH_SHORT).show();
                }
            }).setNegativeButton("否",null).show();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Rule_0Activity.class);
        getActivity().startActivity(intent);
    }
}