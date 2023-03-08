package com.example.module_health.fragment;

import static android.content.Context.MODE_PRIVATE;
import static com.example.module_health.Service.AuthService.getAuth;
import static Utils.changeTextStyle.change;
import static Utils.changeTextStyle.change_1;
import static Utils.changeTextStyle.change_2;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.davistin.widget.RulerView;
import com.example.module_health.Activity.PhotoActivity;
import com.example.module_health.R;

import com.example.module_health.Service.MusicService;
import com.example.module_health.view.StepArcView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Module_healthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


@SuppressLint("DefaultLocale")
public class Module_healthFragment extends Fragment implements  View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;

    private String[] permissions={Manifest.permission.ACTIVITY_RECOGNITION};
    private SensorManager mSensorMgr; // 声明一个传感管理器对象
    private int mStepDetector ; // 累加的步行检测次数
    private int mStepCounter = 0; // 计步器统计的步伐数目
    private Button stop;
    private Button start;
    private CardView off;
    private CardView on;
    private CardView bmiCard;
    private CircleImageView circleImageView;
    private Button eye_button;
    private TextView irealy;
    private TextView BMI_text0;
    private TextView BMI_text_1;
    private TextView Heart_text_0;
    private TextView Heart_text_1;
    private TextView Step_text_0;
    private TextView Step_text_1;
    private ImageView heartPicture;
    private ImageView stepPicture;
    private ImageView bmiPicture;
    ObjectAnimator circleAnimator;
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
        Log.d("hao","oncreateview");
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

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getAuth();
            }
        });
//        thread.start();
        init_text();
        init_cardText();
        makeAnimator();
        return view;
    }
    //播放动画
    private void makeAnimator(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(heartPicture, "alpha", 1f, 0.4f, 1f);
        animator.setDuration(5000);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(stepPicture,"translationX",250,0);
        animator1.setDuration(20000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(bmiPicture,"translationY",15,0,15);
        animator2.setDuration(4000);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(eye_button,"alpha",1f,0.5f,1f);
        animator3.setDuration(2000);
        circleAnimator = ObjectAnimator.ofFloat(circleImageView,"rotation",0,360);
        circleAnimator.setDuration(50000);
        //循环播放
        animator.setRepeatCount(-1);
        animator1.setRepeatCount(-1);
        animator2.setRepeatCount(-1);
        animator3.setRepeatCount(-1);
        circleAnimator.setRepeatCount(-1);
        //开始
        animator.start();
        animator1.start();
        animator2.start();
        animator3.start();

    }

    private void init_cardText() {
        BMI_text0 = view.findViewById(R.id.bmi_text);
        BMI_text_1 = view.findViewById(R.id.bmi_text1);
        bmiCard.setOnClickListener(this);
        change(BMI_text0,getActivity());
        change(BMI_text_1,getActivity());
        Heart_text_0 = view.findViewById(R.id.heart_text);
        Heart_text_1 = view.findViewById(R.id.heart_text1);
        change(Heart_text_0,getActivity());
        change(Heart_text_1,getActivity());
        Step_text_0 = view.findViewById(R.id.step_text);
        Step_text_1 = view.findViewById(R.id.step_text1);
        change(Step_text_0,getActivity());
        change(Step_text_1,getActivity());
        heartPicture = view.findViewById(R.id.heartpicture);
        stepPicture = view.findViewById(R.id.step_picture);
        bmiPicture = view.findViewById(R.id.bmi_picture);
        circleImageView = view.findViewById(R.id.circleImageView);
    }


    private void init_text() {
        bmiCard = view.findViewById(R.id.bmicard);
        stop = view.findViewById(R.id.stop);
        circleImageView = view.findViewById(R.id.circleImageView);
        start = view.findViewById(R.id.start);
        irealy = view.findViewById(R.id.ireally);
        eye_button = view.findViewById(R.id.eye_button);
        off = view.findViewById(R.id.off);
        on = view.findViewById(R.id.on);

        eye_button.setOnClickListener(this);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        circleImageView.setOnClickListener(this);
        change(irealy,getActivity());

//        mCardView_5.setOnClickListener(this);
//        mCardView6.setOnClickListener(this);
//        change_2(mTextView_1,getActivity());
//        change_2(mTextView_2,getActivity());
//        change_1(mTextView_3,getActivity());
//        change_2(bmi_text,getActivity());
//        change_2(mTextView_4,getActivity());
//        change_2(mTextView_5,getActivity());
//        change_2(music,getActivity());
//        change(mTextView_3,getActivity());
//        count(bmi_text1);
    }
    //算bmi的那个
    private void count(TextView bmi_text1) {
        if (bmi_text1.getText().toString().equals("")) {
            bmi_text1.setText("未知");
        } else {


        }
    }

    @Override
    public void onClick(View v) {
        Intent MusicIntent = new Intent(getActivity(), MusicService.class);

        //从灵动岛转到放音乐那个
       if(v.getId()==R.id.eye_button){
            String id = "oncreate";
            off.setVisibility(v.GONE);
            MusicIntent.putExtra("action",id);
            getActivity().startService(MusicIntent);
            on.setVisibility(v.VISIBLE);
            circleAnimator.start();
        }
        //暂停音乐
        if(v.getId()==R.id.stop){
            start.setVisibility(v.VISIBLE);
            String id = "pause";
//            musicService.pauseMusic();
            circleAnimator.pause();
            MusicIntent.putExtra("action",id);
            getActivity().startService(MusicIntent);
            stop.setVisibility(v.GONE);
        }
        //继续播放音乐
        if(v.getId()==R.id.start){
            start.setVisibility(v.GONE);
            String id = "resume";
            circleAnimator.resume();
            MusicIntent.putExtra("action",id);
            getActivity().startService(MusicIntent);
            stop.setVisibility(v.VISIBLE);
        }

        //回到灵动岛状态
        if(v.getId()==R.id.circleImageView){
            on.setVisibility(v.GONE);
            getActivity().stopService(MusicIntent);
            off.setVisibility(v.VISIBLE);
            start.setVisibility(v.GONE);
            circleAnimator.pause();
            stop.setVisibility(v.VISIBLE);
        }
        //点击bmiCard,进入界面输入身高体重
        if(v.getId()==R.id.bmicard){

        }

//        if(v.getId()==R.id.button) {
////            knowYourBmi(getActivity(), height_0, weight_0, height, weight, enter_0, enter_1);
////            Log.d("hao","");
//
//        }
//        else if(v.getId()==R.id.cardView5){
//           clockIn(getActivity());
//        }
//        else if(v.getId()==R.id.cardView6){
//            advice(getActivity());
//        }
    }

}
