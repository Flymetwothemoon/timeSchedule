package com.example.module_homepage.fragment;

import static com.example.module_homepage.utils.changeTextStyle.change;
import static com.example.module_homepage.utils.changeTextStyle.change_1;
import static com.example.module_homepage.utils.changeTextStyle.change_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_homepage.R;
import com.example.module_homepage.activity.DietActivity;
import com.example.module_homepage.activity.EnterActivity;
import com.example.module_homepage.activity.MenuActivity;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@Route(path = "/homepage/homepage1")
public class HomePageFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView intake_title7;
    private TextView intake_title;
    private TextView editText;
    private TextView heathyDiet;
    private TextView fruit_text;
    private ImageView fruit_imag;
    private TextView drink_text;
    private TextView food_text;
    private TextView recipe_0;
    private TextView recipe_0name;
    private TextView todayrecipe;
    private TextView recipe_1;
    private TextView recipe_1name;
    private TextView more;
    private TextView introduce;
    private TextView yellowfishtext;
    private TextView menu_0;
    private TextView cooktime_0;
    private TextView whathard_0;
    private TextView zhajiangnoodleText;
    private TextView menu_1;
    private TextView cooktime_1;
    private TextView hard_1;
    private ImageView drink_image;
    private ImageView food_image;
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
        fruit_imag = view.findViewById(R.id.fruit_image);
        cooktime_1 = view.findViewById(R.id.cooktime_1);
        recipe_0 = view.findViewById(R.id.recipe_0);
        zhajiangnoodleText = view.findViewById(R.id.zhajiangnoodleText);
        recipe_0name = view.findViewById(R.id.recipe_0name);
        todayrecipe = view.findViewById(R.id.todayrecipe);
        recipe_1 = view.findViewById(R.id.recipe_1);
        recipe_1name = view.findViewById(R.id.recipe_1name);
        introduce = view.findViewById(R.id.introduce);
        yellowfishtext = view.findViewById(R.id.yellowfishtext);
        more = view.findViewById(R.id.more);
        menu_0 = view.findViewById(R.id.menu_0);
        cooktime_0 = view.findViewById(R.id.cooktime_0);
        whathard_0 = view.findViewById(R.id.hard_0);
        menu_1 = view.findViewById(R.id.menu_1);
        hard_1 = view.findViewById(R.id.hard_1);
        food_image = view.findViewById(R.id.food_image);
        drink_image = view.findViewById(R.id.drink_image);
                        change(heathyDiet,drink_text,fruit_text,
                                food_text,todayrecipe,introduce,
                                getContext());
//                        change(drink_text,getActivity());
//                        change(fruit_text,getActivity());
//                        change(food_text,getActivity());
//                        change(todayrecipe,getActivity());
                        change_2(recipe_0,recipe_1,recipe_1name
                                ,recipe_0name,more,cooktime_1,
                                yellowfishtext,cooktime_0,
                                whathard_0,menu_0,menu_1,hard_1,
                                zhajiangnoodleText,getActivity());
//                        change_2(recipe_1,getActivity());
//                        change_2(recipe_1name,getActivity());
//                        change_2(recipe_0name,getActivity());
//                        change_2(more,getActivity());
//                        change_2(cooktime_1,getActivity());
//                        change_2(yellowfishtext,getActivity());
//                        change_2(cooktime_0,getActivity());
//                        change_2(whathard_0,getActivity());
//                        change_2(menu_0,getActivity());
////                        change(introduce,getActivity());
//                        change_2(menu_1,getActivity());
//                        change_2(hard_1,getActivity());
//                        change_2(zhajiangnoodleText,getActivity());



        fruit_imag.setOnClickListener(this);
        fruit_text.setOnClickListener(this);
        editText.setOnClickListener(this);
        more.setOnClickListener(this);
        drink_image.setOnClickListener(this);
        drink_text.setOnClickListener(this);
        food_image.setOnClickListener(this);
        food_text.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.editText) {
            Intent intent = new Intent(getActivity(), EnterActivity.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.fruit_text||view.getId()==R.id.fruit_image){
            Intent intent = new Intent(getActivity(), DietActivity.class);
            intent.putExtra("fruit","fruit");
            startActivity(intent);
        }
        else if(view.getId()==R.id.more){
            Intent intent = new Intent(getActivity(), MenuActivity.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.drink_text||view.getId()==R.id.drink_image){
            Intent intent = new Intent(getActivity(), DietActivity.class);
            intent.putExtra("fruit","drink");
            startActivity(intent);
        }
        else if(view.getId()==R.id.food_image||view.getId()==R.id.food_text){
            Intent intent = new Intent(getActivity(),DietActivity.class);
            intent.putExtra("fruit","main");
            startActivity(intent);
        }
    }
}
