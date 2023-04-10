package com.example.module_homepage.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.module_homepage.R;
import com.example.module_homepage.adapter.diet;
import com.example.module_homepage.adapter.dietAdapter;
import com.example.module_homepage.utils.sendOkHttp1;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link drink_0Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class drink_0Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<diet> mList = new ArrayList<>();
    private View mView;
    private RecyclerView fruitRecycler;
    public drink_0Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment drink_0Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static drink_0Fragment newInstance(String param1, String param2) {
        drink_0Fragment fragment = new drink_0Fragment();
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
        if(mView==null){
            mView = inflater.inflate(R.layout.fragment_drink_0, container, false);
        }
        init();
        return mView;
    }
    private void init(){
        fruitRecycler = mView.findViewById(R.id.fruit_recycler);
        dietAdapter adapter = new dietAdapter(getContext(),mList);
        new sendOkHttp1().send(mList,adapter,getActivity(),"10");
        fruitRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        fruitRecycler.setAdapter(adapter);
    }
}