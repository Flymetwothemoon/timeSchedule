package com.example.module_health.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
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
import com.example.module_health.service.StepService;
import com.example.module_health.service.UpdateUiCallBack;
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
public class Module_healthFragment extends Fragment {

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
    private Adapter adapter;
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
        startSerice();
    }
    private boolean isBind = false;
    private void startSerice() {
        Intent intent = new Intent(getActivity(), StepService.class);
        getActivity().startService(intent);
    }
    /**
     * 用于查询应用服务（application Service）的状态的一种interface，
     * 更详细的信息可以参考Service 和 context.bindService()中的描述，
     * 和许多来自系统的回调方式一样，ServiceConnection的方法都是进程的主线程中调用的。
     */
    ServiceConnection conn = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            StepService stepService = ((StepService.StepBinder) service).getService();
            cc.setCurrentCount(10000, stepService.getStepCount());
            //设置步数监听回调
            stepService.registerCallback(new UpdateUiCallBack() {
                @Override
                public void updateUi(int stepCount) {
                    cc.setCurrentCount(10000, stepCount);
                }
            });
        }
        /**
         * 当与Service之间的连接丢失的时候会调用该方法，
         * 这种情况经常发生在Service所在的进程崩溃或者被Kill的时候调用，
         * 此方法不会移除与Service的连接，当服务重新启动的时候仍然会调用 onServiceConnected()。
         * @param name 丢失连接的组件名称
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    };


   

    private void init_0(){
        Calendar calendar = Calendar.getInstance();
        for (int i =0;i<31;i++){
            Data data = new Data();
            data.day = String.valueOf(calendar.get(Calendar.DATE));
            data.dayOfWeekend ="星期"+(calendar.get(Calendar.DAY_OF_WEEK)-1);
            if(i==0){
                data.color = 0xff95CBCB;
            }
            else{
                data.color = 0xffE6E6FA;
            }
            util_0.exchange(data);
            mList.add(data);
            calendar.add(Calendar.DATE,1);
        }
    }

}