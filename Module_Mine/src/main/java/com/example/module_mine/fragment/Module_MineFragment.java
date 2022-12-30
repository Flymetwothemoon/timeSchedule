package com.example.module_mine.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_mine.Adapter.card;
import com.example.module_mine.Adapter.card_adapter;
import com.example.module_mine.R;

import java.util.ArrayList;
import java.util.List;

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
    RecyclerView recyclerView;
    public List<card>mList = new ArrayList<>();
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
        card_adapter adapter = new card_adapter(mList);
        init_0();
        recyclerView = view.findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(adapter);
    }
    private void init_0(){
        card card_0 = new card();
        card_0.setImage(R.drawable.order);
        card_0.setTextView("我的点赞");
        mList.add(card_0);
        card card_1 = new card();
        card_1.setImage(R.mipmap.record);
        card_1.setTextView("浏览记录" );
        mList.add(card_1);
        card card_2 = new card();
        card_2.setImage(R.mipmap.pocket) ;
        card_2.setTextView("我的收藏");
        mList.add(card_2);
    }

}