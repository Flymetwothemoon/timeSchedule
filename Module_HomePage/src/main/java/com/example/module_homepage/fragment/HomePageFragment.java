package com.example.module_homepage.fragment;

import static com.example.module_homepage.utils.changeTextStyle.change;
import static com.example.module_homepage.utils.changeTextStyle.change_1;
import static com.example.module_homepage.utils.changeTextStyle.change_2;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_homepage.R;
import com.example.module_homepage.activity.DrinkActivity;
import com.example.module_homepage.activity.foodActivity;
import com.example.module_homepage.adapter.banner_adapter;
import com.example.module_homepage.bean.banner_bean;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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

    //轮播图的使用
    private Banner mBanner;
    private List<banner_bean> banner_List;
    private View mView;
    //喝水提醒
    private ImageView imageView;
    private TextView water_title;
    private TextView tv_water_number;
    private TextView tv_water_percent;
    private TextView foodTitle;
    private TextView text_breakfast;
    private TextView text_lunch;
    private TextView text_dinner;
    private TextView breakfast_saying;
    private TextView lunch_saying;
    private TextView dinner_saying;
    private CardView mCardView;
    private CardView mCardView_2;
    private CardView mCardView_4;
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
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        //轮播图的添加

        banner_List = new ArrayList<>();
        init();

        //轮播图的适配
        mBanner = view.findViewById(R.id.banner);
        mBanner.setAdapter(new banner_adapter(getActivity(), banner_List));
        // Set Banner is auto to loop.
        mBanner.isAutoLoop(true);
        // Set an indicator for Banner.
        mBanner.setIndicator(new CircleIndicator(getActivity()));
        mBanner.start();
        //喝水提醒
        imageView = view.findViewById(R.id.drink_enter);
        intake_title7 = view.findViewById(R.id.intake_title7);
        imageView.setOnClickListener(this);
        tv_water_number = view.findViewById(R.id.water_number);
        water_title = view.findViewById(R.id.water_title);
        intake_title = view.findViewById(R.id.intake_title);
        foodTitle = view.findViewById(R.id.title_food);
        text_breakfast = view.findViewById(R.id.text_breakfast);
        text_dinner = view.findViewById(R.id.text_dinner);
        text_lunch = view.findViewById(R.id.text_lunch);
        breakfast_saying = view.findViewById(R.id.breakfast_saying);
        lunch_saying = view.findViewById(R.id.lunch_saying);
        dinner_saying = view.findViewById(R.id.dinner_saying);
        tv_water_percent=view.findViewById(R.id.water_percent);
        mCardView = view.findViewById(R.id.cardView);
        mCardView_2 = view.findViewById(R.id.cardView2);
        mCardView_4 = view.findViewById(R.id.cardView4);
        mCardView_4.setOnClickListener(this);
        mCardView_2.setOnClickListener(this);
        mCardView.setOnClickListener(this);
        change_2(intake_title7,getActivity());
        change_2(intake_title,getContext());
        change_2(text_breakfast,getActivity());
        change_2(text_lunch,getActivity());
        change_2(text_dinner,getActivity());
        change(water_title,getContext());
        change(foodTitle,getContext());
        change_2(breakfast_saying,getActivity());
        change_2(lunch_saying,getActivity());
        change_2(dinner_saying,getActivity());
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("text", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("bmi",Context.MODE_PRIVATE);
        Handler handler = new Handler();
        Timer timer = new Timer();
        SharedPreferences sharedPreferences_0= getActivity().getSharedPreferences("text",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences_0.edit();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(getActivity()==null){
                            return;
                        }
                        else{
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Calendar calendar = Calendar.getInstance();
                                    int year = calendar.get(Calendar.YEAR);
                                    int month = calendar.get(Calendar.MONTH);
                                    int data = calendar.get(Calendar.DATE);
                                    if(year!=sharedPreferences1.getInt("myYear",0)||month!=sharedPreferences1.getInt("myMonth",0)||data!=sharedPreferences1.getInt("myData",0)){
                                        Log.d("TAG666",""+sharedPreferences1.getInt("myData",0));
                                        editor.putString("text", "0");
                                        editor.commit();
                                    }
                                    int water_numbers = Integer.parseInt(sharedPreferences.getString("text", "0"));
//                        Log.d("333", "onCreateView: " + water_numbers);
                                    tv_water_number.setText(water_numbers + "");
                                    change_2(tv_water_number,getContext());
                                    Double percent;
                                    int cnt = 1;
                                    if(water_numbers%1500==0||water_numbers%30==0){
                                        cnt =0;
                                    }
                                    if(water_numbers==0){
                                        percent = 0.0;
                                    }
                                    else {
                                        double water_numbers_0 = 1.0*water_numbers;
                                        percent = Double.valueOf(water_numbers_0/1500);
                                    }
                                    if(cnt==1) {
                                        tv_water_percent.setText(String.format("%.3f", percent * 100) + "%");
                                        change_2(tv_water_percent,getContext());
                                    }
                                    else {
                                        tv_water_percent.setText(String.format("%.0f", percent * 100) + "%");
                                        change_2(tv_water_percent,getContext());
                                    }
                                }
                            });

                        }

                    }
                });
            }
        }, 0, 100);
        return view;
    }

    private void init() {
        banner_List.add(new banner_bean(R.mipmap.picture));
        banner_List.add(new banner_bean(R.mipmap.picture));
        banner_List.add(new banner_bean(R.mipmap.picture));
        banner_List.add(new banner_bean(R.mipmap.picture));
        banner_List.add(new banner_bean(R.mipmap.picture));
    }


    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bmi",Context.MODE_PRIVATE);
        String height = sharedPreferences.getString("height","");
        String weight = sharedPreferences.getString("weight","");
        String bmi = "-1";
        float a=-1;
        Log.d("TAG222",""+height);
        Log.d("TAG222",""+weight);
        if(height.length()>=1&&weight.length()>=1) {
            Log.d("TAG222", "weight" + weight);
            Log.d("TAG222", "height" + height);
            float height_0 = Float.parseFloat(height) / 100;
            Log.d("TAG222","qw"+height_0);
            if (height_0 < 1) {
                height_0 = 1;
            }
            float weight_0 = Float.parseFloat(weight);
            if (height == null) {
               bmi="-1";
            } else {
                 a = weight_0 / (height_0 * height_0);
                bmi =String.format("%.2f", a);
            }
        }
        if (v.getId() == R.id.drink_enter) {
            Intent intent = new Intent(v.getContext(), DrinkActivity.class);
            SharedPreferences.Editor editor = getActivity().getSharedPreferences("bmi",Context.MODE_PRIVATE).edit();
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            editor.putInt("myYear",year);
            Log.d("TAG666",""+"year"+year);
            editor.putInt("myMonth",calendar.get(Calendar.MONTH));
            editor.putInt("myData",calendar.get(Calendar.DATE));
            editor.commit();
            getActivity().startActivity(intent);
        }
        if(v.getId()==R.id.cardView){
            if(bmi.equals("-1")){
                Toast.makeText(getContext(),"请先完成健康界面的身体质量指数项目",Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(getActivity(), foodActivity.class);
                intent.putExtra("bmi_0",a);
                intent.putExtra("food",0);
                getActivity().startActivity(intent);
            }
        }
        if(v.getId()==R.id.cardView4){
            if(bmi.equals("-1")){
            Toast.makeText(getContext(),"请先完成健康界面的身体质量指数项目",Toast.LENGTH_SHORT).show();
        }
            else{
                Intent intent = new Intent(getActivity(), foodActivity.class);
                intent.putExtra("bmi_0",a);
                intent.putExtra("food",1);
                getActivity().startActivity(intent);
            }
        }
        if(v.getId()==R.id.cardView2){
            if(bmi.equals("-1")){
                Toast.makeText(getContext(),"请先完成健康界面的身体质量指数项目",Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(getActivity(), foodActivity.class);
                intent.putExtra("bmi_0",a);
                intent.putExtra("food",2);
                getActivity().startActivity(intent);
            }
        }
    }

}
