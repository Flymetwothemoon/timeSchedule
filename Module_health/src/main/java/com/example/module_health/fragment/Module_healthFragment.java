package com.example.module_health.fragment;

import static android.content.Context.MODE_PRIVATE;
import static Utils.changeTextStyle.change;
import static Utils.changeTextStyle.change_1;
import static Utils.changeTextStyle.change_2;
import static Utils.changeTime.changeHour;
import static Utils.changeTime.changeMinute;
import static Utils.clockin.advice;
import static Utils.clockin.clockIn;
import static Utils.countBMI.showHeight;
import static Utils.countBMI.showWeight;
import static Utils.equalTime.timeEqual;
import static Utils.healthBody.knowYourBmi;
import static Utils.music.music_0;
import static Utils.openMusic.openmusic;
import static Utils.sleeping.whenSleeping;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.davistin.widget.RulerView;
import com.example.module_health.R;

import com.example.module_health.Service.MusicService;
import com.example.module_health.view.StepArcView;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Module_healthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


@SuppressLint("DefaultLocale")
public class Module_healthFragment extends Fragment implements SensorEventListener, View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private CardView mCardView;
    private StepArcView cc;
    private TextView mTextView_1;
    private TextView mTextView_2;
    private TextView mTextView_3;
    private TextView mTextView_4;
    private TextView bmi_text;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private Switch mSwitch;
    private TextView bmi_text1;
    private TextView height_0;
    private TextView weight_0;
    private Button mButton;
    private RulerView height;
    private RulerView weight;
    private Button enter_0;
    private Button enter_1;
    private TextView TextView_3;
    private TextView mTextView_5;
    private TextView music;
    private CardView mCardView6;
    private CardView mCardView_5;
    private TextView today_text;
    private TextView now_text;
    private TextView second;
    private String[] permissions={Manifest.permission.ACTIVITY_RECOGNITION};
    private SensorManager mSensorMgr; // 声明一个传感管理器对象
    private int mStepDetector = -1; // 累加的步行检测次数
    private int mStepCounter = 0; // 计步器统计的步伐数目
    public Module_healthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Module_healthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Module_healthFragment newInstance(String param1, String param2) {
        Module_healthFragment fragment = new Module_healthFragment();
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
        if(view==null){
            view = inflater.inflate(R.layout.fragment_module_health, container, false);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // 检查该权限是否已经获取
            int get = ContextCompat.checkSelfPermission(getActivity(), permissions[0]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (get != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求自动开启权限
                ActivityCompat.requestPermissions(getActivity(), permissions, 321);
            }
        }
        mSwitch = view.findViewById(R.id.switch_0);
        mTextView_3 = view.findViewById(R.id.text_3);
        openmusic(mTextView_3,view,getActivity());
        init();
        initswitch();
        init_text();
        return view;
    }

    private void initswitch() {

        final int[] hour = {0};
        final int[] minute1 = {0};
        getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run () {
                            mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if (isChecked) {
                                        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                                            @Override
                                            public void onTimeSet(TimePicker view1, int hourOfDay, int minute) {
                                                whenSleeping(hour, hourOfDay, minute1, minute, view, mTextView_3, getActivity());
                                            }
                                        }, 0, 1, true);
                                        timePickerDialog.show();
                                    } else {
                                        String a = "未设置";
                                        mTextView_3.setText(a);
                                    }
                                }
                            });
//                    openmusic(mTextView_3,view,getActivity());
                }
        });
    }

    private void init_text() {
        mTextView_1 = view.findViewById(R.id.text_1);
        mTextView_2 = view.findViewById(R.id.text_2);
        mTextView_4 = view.findViewById(R.id.text_4);
        mTextView_5 = view.findViewById(R.id.text_5);
        mCardView_5 = view.findViewById(R.id.cardView5);
        mCardView6 = view.findViewById(R.id.cardView6);
        bmi_text = view.findViewById(R.id.bmi_text);
        bmi_text1 = view.findViewById(R.id.bmi_text1);
        enter_0 = view.findViewById(R.id.enter_0);
        enter_1 = view.findViewById(R.id.enter_1);
        mButton = view.findViewById(R.id.button);
        music = view.findViewById(R.id.music);
        mButton.setOnClickListener(this);
        mCardView_5.setOnClickListener(this);
        mCardView6.setOnClickListener(this);
        change_2(mTextView_1,getActivity());
        change_2(mTextView_2,getActivity());
        change_1(mTextView_3,getActivity());
        change_2(bmi_text,getActivity());
        change_2(bmi_text1,getActivity());
        change_2(mTextView_4,getActivity());
        change_2(mTextView_5,getActivity());
        change_2(music,getActivity());
        count(bmi_text1);
    }
    private void count(TextView bmi_text1){
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences("bmi",MODE_PRIVATE);
                        String height = sharedPreferences.getString("height","");
                        String weight = sharedPreferences.getString("weight","");
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
                                bmi_text1.setText("未知");
                            } else {
                                float a = weight_0 / (height_0 * height_0);
                                bmi_text1.setText(String.format("%.2f",a));
                            }
                        }
                    }
                },0,1000);


    }
    private void init(){

        cc = (StepArcView) view.findViewById(R.id.cc);
        initData();

    }
    private void initData(){
        cc.setCurrentCount(10000,0);
        initStepSensor();
//        startSerice();
    }

    private void initStepSensor() {
        mSensorMgr = (SensorManager) this.getActivity().getSystemService(Context.SENSOR_SERVICE);
        int suitable = 0;
        // 获取当前设备支持的传感器列表
        List<Sensor> sensorList = mSensorMgr.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensorList) {
            Log.d("TAG1",String.valueOf(sensor.getType()));
            if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) { // 找到步行检测传感器
                suitable += 1;
                Log.d("TAG1","启动3");
                // 给步行检测传感器注册传感监听器
                mSensorMgr.registerListener(this,
                        mSensorMgr.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR),
                        SensorManager.SENSOR_DELAY_NORMAL);
            } else if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) { // 找到计步器
                suitable += 10;
                // 给计步器注册传感监听器
                Log.d("TAG1","启动4");
                mSensorMgr.registerListener(this,
                        mSensorMgr.getDefaultSensor(Sensor.TYPE_STEP_COUNTER),
                        SensorManager.SENSOR_DELAY_NORMAL);
                mSensorMgr.registerListener(this,
                        mSensorMgr.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR),
                        SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
        Log.d("TAG1","fangq"+suitable);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d("TAG1","启动了");
        if (event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) { // 步行检测事件
            Log.d("TAG1","启动1");
            if (event.values[0] == 1.0f) {
                mStepDetector++; // 步行检测事件
            }
        } else if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) { // 计步器事件
            mStepCounter = (int) event.values[0]; // 计步器事件
            mStepDetector++;
        }
        cc.setCurrentCount(10000,mStepDetector);

    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorMgr.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button) {
            knowYourBmi(getActivity(), height_0, weight_0, height, weight, enter_0, enter_1);
            count(bmi_text1);
        }
        else if(v.getId()==R.id.cardView5){
           clockIn(getActivity());
        }
        else if(v.getId()==R.id.cardView6){
            advice(getActivity());
        }
    }
}