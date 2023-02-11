package com.example.module_homepage.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.module_homepage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FitActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lv_fit;
    private SimpleAdapter simpleAdapter;
    private ImageView iv_back;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FitActivity.this.finish();
            }
        });

        lv_fit = findViewById(R.id.lv_fit);
        lv_fit.addHeaderView(new View(this));
        lv_fit.addFooterView(new View(this));
        simpleAdapter = new SimpleAdapter(FitActivity.this, getData(),
                R.layout.tree_menu,
                new String[]{"title", "image"}, new int[]{R.id.tv_name, R.id.iv_image});
        lv_fit.setAdapter(simpleAdapter);
        lv_fit.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:
                alert = null;
                builder = new AlertDialog.Builder(FitActivity.this);
                alert = builder.setTitle("喝水小知识")
                        .setMessage("成年人每天消耗水分约2500毫升，从\n食物中获取约1000毫升，所以每天需" +
                                "\n要喝水补充约1500毫升.").setNegativeButton("知道啦",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).create();
                alert.show();
                break;
        }
    }
    private List<Map<String, Object>> getData() {
        String[] titles = {"喝水小知识"};
        int[] images = {R.drawable.knowledge};
        List<Map<String, Object>> list= new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("title", titles[i]);
            map.put("image", images[i]);
            list.add(map);
        }
        return list;
    }


}