package com.example.module_homepage.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.module_homepage.R;
import com.example.module_homepage.adapter.MyAdapter;
import com.example.module_homepage.adapter.MyAdapterClock;

import java.util.ArrayList;
import java.util.List;

public class ActivityClock extends AppCompatActivity {
    private ImageView iv_back; // 返回
    private AlarmManager alarmManager;
    private PendingIntent pi;
    private Context mContext;
    private ListView list_regular_clock;
    private ListView list_alternate_clock;
    private List<String> mRList = new ArrayList<>();
    private List<String> mAList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_clock);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        list_regular_clock = findViewById(R.id.list_regular_clock);
        list_alternate_clock = findViewById(R.id.list_alternate_clock);
        list_regular_clock.addHeaderView(new View(this));
        list_alternate_clock.addHeaderView(new View(this));
        list_regular_clock.addFooterView(new View(this));
        list_alternate_clock.addFooterView(new View(this));
        mContext = ActivityClock.this;

        initRegularClock();

        MyAdapter adapter1 = new MyAdapter(mContext, mRList);
        list_regular_clock.setAdapter(adapter1);
        adapter1.setOnCheckedChangeListener(new MyAdapter.onCheckedChangeListener() {
            @Override
            public void onCheckedChanged(int i, boolean isChecked) {
                switch (i) {

                }
            }
        });

        initAlternateClock();
        MyAdapterClock adapter2 = new MyAdapterClock(mContext, mAList);
        list_alternate_clock.setAdapter(adapter2);
        adapter2.setOnCheckedChangeListener(new MyAdapterClock.onCheckedChangeListener() {
            @Override
            public void onCheckedChanged(int i, boolean isChecked) {
                switch (i) {
                    case 0:
                        break;
                }
            }
        });

    }
    public void initRegularClock() {
        mRList.add("09:00");
        mRList.add("10:30");
        mRList.add("14:30");
        mRList.add("16:00");
        mRList.add("20:00");
    }

    public void initAlternateClock() {
        mAList.add("间隔提醒");
    }
    }
