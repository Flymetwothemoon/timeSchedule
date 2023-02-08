package com.example.module_news.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_news.Module_newsActivity;
import com.example.module_news.R;
import com.example.module_news.Search_newsActivity;
import com.example.module_news.Text_newsActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Module_newsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@Route(path = "/news/news1")
public class Module_newsFragment extends Fragment implements AdapterView.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView imageView;
    public Module_newsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Module_newsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Module_newsFragment newInstance(String param1, String param2) {
        Module_newsFragment fragment = new Module_newsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public String[] titleArray = {"官方消息1","官方消息1","官方消息1","官方消息1","官方消息1",
            "官方消息1","官方消息1","官方消息1","官方消息1","官方消息1",
            "官方消息1","官方消息1","官方消息1","官方消息1","官方消息1",
            "官方消息1","官方消息1","官方消息1","官方消息1","官方消息1",
            "官方消息1","官方消息1","官方消息1","官方消息1","官方消息1",};
    public String[] textArray = {"内容","内容","内容","内容","内容",
            "内容","内容","内容","内容","内容",
            "内容","内容","内容","内容","内容",
            "内容","内容","内容","内容","内容",
            "内容","内容","内容","内容","内容"};
    private ListView listView;
    SimpleAdapter simpleAdapter;

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
        View view=inflater.inflate(R.layout.fragment_module_news,container,false);


        listView= view.findViewById(R.id.list_view);


        simpleAdapter=new SimpleAdapter(getActivity(),getData(),R.layout.item_layout,new String[] {"titles","texts"},new int[] {R.id.tile,R.id.text});
        listView.setAdapter(simpleAdapter);

        imageView= view.findViewById(R.id.search);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"search",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getActivity(), Search_newsActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }



    private List<Map<String,String>> getData() {
        List<Map<String,String>> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map map=new HashMap();
            map.put("titles",titleArray[i]);
            map.put("texts",textArray[i]);
            list.add(map);
        }
     return list;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent= new Intent(getActivity(), Text_newsActivity.class);
        startActivity(intent);
    }

}