package com.example.module_health.fragment;

import static android.content.Context.SENSOR_SERVICE;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_health.R;
import com.example.module_health.adapter.Adapter;
import com.example.module_health.bean.Data;

import com.example.module_health.view.StepArcView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Utils.SharedPreferencesUtils;
import Utils.util_0;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Module_healthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@Route(path = "/health/health1")

@SuppressLint("DefaultLocale")
public class Module_healthFragment extends Fragment implements SensorEventListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private CardView mCardView;
    private StepArcView cc;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private String[] permissions={Manifest.permission.ACTIVITY_RECOGNITION};
    private Adapter adapter;
    private TextView mTextView;
    private SensorManager mSensorMgr; // 声明一个传感管理器对象
    private int mStepDetector = -1; // 累加的步行检测次数
    private int mStepCounter = 0; // 计步器统计的步伐数目


    private List<Data>mList = new ArrayList<>();
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
        init();
        return view;
    }
    private void init(){

        adapter = new Adapter(mList);
        init_0();
        cc = (StepArcView) view.findViewById(R.id.cc);
        initData();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void initData(){
        cc.setCurrentCount(10000,0);
        initStepSensor();
        mTextView = view.findViewById(R.id.text1111);
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
    //日历
    private void init_0(){
        Calendar calendar = Calendar.getInstance();
        for (int i =-7;i<31;i++){
            Data data = new Data();
            data.day = String.valueOf(calendar.get(Calendar.DATE));
            data.dayOfWeekend ="星期"+(calendar.get(Calendar.DAY_OF_WEEK)-1);
            if(i==0){
                data.color = 0xff95CBCB;//今日的设置为一个颜色
            }
            else{
                data.color = 0xffE6E6FA;//其他时间设置另一个颜色
            }
            util_0.exchange(data);
            mList.add(data);
            calendar.add(Calendar.DATE,1);//往后增加
        }
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
        String desc = String.format("设备检测到您当前走了%d步，总计数为%d步",
                mStepDetector, mStepCounter);
        mTextView.setText(desc);
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
}