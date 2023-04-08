package com.example.module_homepage.fragment;

import static com.example.module_homepage.utils.changeTextStyle.change;
import static com.example.module_homepage.utils.changeTextStyle.change_1;
import static com.example.module_homepage.utils.changeTextStyle.change_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_homepage.R;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@Route(path = "/homepage/homepage1")
public class HomePageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView intake_title7;
    private TextView intake_title;
    private EditText editText;
    private TextView heathyDiet;
    private TextView fruit_text;
    private TextView drink_text;
    private TextView food_text;
    View view;
    public HomePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePageFragment newInstance(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment();
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
       view = inflater.inflate(R.layout.fragment_home_page, container, false);


        init();


        //喝水提醒


        return view;
    }

    private void init() {
        editText = view.findViewById(R.id.editText);
        heathyDiet = view.findViewById(R.id.diet_text);
        fruit_text = view.findViewById(R.id.fruit_text);
        drink_text = view.findViewById(R.id.drink_text);
        food_text = view.findViewById(R.id.food_text);
        change(heathyDiet,getContext());
        change(drink_text,getActivity());
        change(fruit_text,getActivity());
        change(food_text,getActivity());
    }





}
