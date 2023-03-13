package com.example.module_homepage.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.module_homepage.R;
import com.example.module_homepage.activity.AddActivity;
import com.example.module_homepage.activity.DrinkActivity;
import com.example.module_homepage.activity.FitActivity;
import com.example.module_homepage.utils.Histogram;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrinkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinkFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DrinkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrinkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinkFragment newInstance(String param1, String param2) {
        DrinkFragment fragment = new DrinkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private final int MAX_WATER = 1800;

    private String water; // 饮水量

    private ImageView iv_fit; // 设置
    private ImageView back;

    private Button btn_add; // 添加

    private Histogram histogram;

    private int tempWater;

    //喝水 多了
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;


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
        View view = inflater.inflate(R.layout.fragment_drink, container, false);

        iv_fit = view.findViewById(R.id.iv_fit);
        btn_add = view.findViewById(R.id.btn_add);
        histogram = view.findViewById(R.id.bottle);
        back = view.findViewById(R.id.back);
        iv_fit.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        back.setOnClickListener(this);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("text", Context.MODE_PRIVATE);
        Timer timer = new Timer();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (getActivity() == null) {
                    return;
                } else {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            water = sharedPreferences.getString("text", "0");
//                        Log.d("2222", "onCreateView: " + water);
                            tempWater = Integer.parseInt(water);
                            int tempWater_0 = tempWater;
                            if (tempWater_0 >= 1500) {
                                tempWater_0 = 1500;
                            }
                            if (Integer.parseInt(water) >= 1500) {
                                water = 1500 + "";

                            }
                            histogram.setData(tempWater_0, Integer.parseInt(water), MAX_WATER);
                        }
                    });
                }
            }
        }, 0, 100);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_fit) {
            Intent intent = new Intent(getActivity(), FitActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.btn_add && tempWater >= 1500) {
            Toast.makeText(getContext(), "今天你喝的水已经超标", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btn_add && tempWater < 1500) {

            Intent intent = new Intent(getActivity(), AddActivity.class);

            startActivity(intent);
        } else if (v.getId() == R.id.back) {
            getActivity().finish();
        }
    }
}