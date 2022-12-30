package com.example.module_mine.fragment;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_mine.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.mine;
import Adapter.mineAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Module_MineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@Route(path = "/mine/mine1")
public class Module_MineFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private RecyclerView mRecyclerView;
    private ImageView mImageView;
    private CardView award;
    private List<mine>mList = new ArrayList<>();
    public Module_MineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Module_MineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Module_MineFragment newInstance(String param1, String param2) {
        Module_MineFragment fragment = new Module_MineFragment();
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
            view = inflater.inflate(R.layout.fragment_module__mine, container, false);
        }
        init();
        return view;
    }

    private void init(){
        award = view.findViewById(R.id.award_card);
        mImageView = view.findViewById(R.id.award_image);
        mRecyclerView = view.findViewById(R.id.mine_recycler);
        TextView textView2 = view.findViewById(R.id.textView2);
        TextView textView3 = view.findViewById(R.id.textView3);
        TextView textView4 = view.findViewById(R.id.textview4);
        TextView textView5 = view.findViewById(R.id.textview5);
        Typeface customFont = Typeface.createFromAsset(getActivity().getAssets(), "Alimama_ShuHeiTi_Bold.ttf");
        Typeface customFont1 = Typeface.createFromAsset(getActivity().getAssets(),"TsangerYuYangT_W01_W01.ttf");
        textView2.setTypeface(customFont);
        textView3.setTypeface(customFont);
        textView4.setTypeface(customFont1);
        textView5.setTypeface(customFont1);
        mineAdapter adapter = new mineAdapter(mList);
        init_0();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
        show();
    }
    private void show(){
        award.setCardBackgroundColor(0xffF6E7CA);
        mImageView.setImageResource(R.mipmap.bronze);
    }
    private void init_0(){
        mine mine = new mine();
        mine.something = "我的好友";
        mine.image = R.mipmap.friend;
        mList.add(mine);
        mine mine1 = new mine();
        mine1.something = "一周小结";
        mine1.image = R.mipmap.sum;
        mList.add(mine1);
        mine mine2 = new mine();
        mine2.image = R.mipmap.activity;
        mine2.something = "我的活动";
        mList.add(mine2);
        mine mine4 = new mine();
        mine4.image = R.mipmap.nurse;
        mine4.something = "关怀模式";
        mList.add(mine4);
        mine mine7 = new mine();
        mine7.something = "白天模式";
        mine7.image = R.mipmap.day;
        mList.add(mine7);
        mine mine6 = new mine();
        mine6.something = "黑夜模式";
        mine6.image = R.mipmap.night;
        mList.add(mine6);
        mine mine5 = new mine();
        mine5.something = "我的客服";
        mine5.image = R.mipmap.service;
        mList.add(mine5);
        mine mine3 = new mine();
        mine3.something ="账号管理";
        mine3.image = R.mipmap.manage;
        mList.add(mine3);
    }


}