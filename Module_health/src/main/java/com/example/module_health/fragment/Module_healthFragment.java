package com.example.module_health.fragment;

import static com.example.module_health.Service.AuthService.getAuth;
import static Utils.animator.makeAlpha;
import static Utils.animator.makeAlpha1;
import static Utils.animator.makeRotationX;
import static Utils.animator.makeRotationY;
import static Utils.animator.makeScaleX;
import static Utils.animator.makeTranslationX;
import static Utils.animator.makeTranslationY;

import static Utils.changeTextStyle.change;


import android.Manifest;
import android.animation.ObjectAnimator;

import android.annotation.SuppressLint;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;

import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;


import com.example.module_health.Activity.HeartActivity;
import com.example.module_health.Activity.PhotoActivity;
import com.example.module_health.Activity.WalkActivity;
import com.example.module_health.R;

import com.example.module_health.Service.MusicService;


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
    private ConstraintLayout mConstraintLayout;
    private String[] permissions={Manifest.permission.ACTIVITY_RECOGNITION};
    private SensorManager mSensorMgr; // 声明一个传感管理器对象
    private int mStepDetector ; // 累加的步行检测次数
    private int mStepCounter = 0; // 计步器统计的步伐数目
    private Button stop;
    private Button start;
    private CardView off;
    private CardView on;
    private CardView photoCardView;
    private CardView photoCardView1;
    private CardView bmiCard;
    private CardView heartCard;
    private CardView touchbmi;
    private CardView heartCard1;
    private CardView stepCard;
    private CardView stepCard1;

    private CircleImageView circleImageView;
    private Button eye_button;
    private TextView irealy;
    private TextView BMI_text0;
    private TextView BMI_text_1;
    private TextView Heart_text_0;
    private TextView Heart_text_1;
    private TextView Step_text_0;
    private TextView Step_text_1;
    private TextView photo_text1;
    private TextView photo_text;
    private TextView Heart_text_2;
    private TextView Heart_text_3;
    private TextView Step_text_2;
    private TextView Step_text_3;
    private TextView photo_text2;
    private TextView photo_text3;
    private ImageView photoPicture;
    private ImageView heartPicture;
    private ImageView stepPicture;
    private ImageView bmiPicture;
    private ImageView photoImage_1;
    private ImageView photoImage_2;
    private ImageView photoImage_3;
    private ImageView stepPicture_1;
    private ImageView heartPicture_1;
    private boolean isViewPagerScrollEnabled = false;

    private ViewPager2 mViewPager2;
    ObjectAnimator circleAnimator;
    private ServiceConnection connection = new ServiceConnection() {
        //绑定service
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }
        //解除绑定
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };



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
        String packageName = getContext().getPackageName();
        Log.d("BAG",packageName);
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

        makeAlpha((heartPicture));
        makeAlpha(heartPicture_1);
        makeScaleX(stepPicture);
        makeScaleX(stepPicture_1);
        makeTranslationY(bmiPicture);

        makeTranslationX(eye_button);


        circleAnimator = ObjectAnimator.ofFloat(circleImageView,"rotation",0,360);
        circleAnimator.setDuration(50000);

        makeRotationY(photoPicture);
        makeRotationY(photoImage_2);

        makeRotationX(photoImage_1);
        makeRotationX(photoImage_3);
        makeAlpha1(eye_button);
        //循环播放


        circleAnimator.setRepeatCount(-1);

    }

    private void init_cardText() {
        BMI_text0 = view.findViewById(R.id.bmi_text);
        BMI_text_1 = view.findViewById(R.id.bmi_text1);
        bmiCard.setOnClickListener(this);
        change(BMI_text0,getActivity());
        change(BMI_text_1,getActivity());
        Heart_text_0 = view.findViewById(R.id.heart_text);
        Heart_text_1 = view.findViewById(R.id.heart_text1);
        Heart_text_2 = view.findViewById(R.id.heart_text2);
        Heart_text_3 = view.findViewById(R.id.heart_text3);

        change(Heart_text_0,getActivity());
        change(Heart_text_1,getActivity());
        change(Heart_text_2,getActivity());
        change(Heart_text_3,getActivity());

        Step_text_0 = view.findViewById(R.id.step_text);
        Step_text_1 = view.findViewById(R.id.step_text1);
        Step_text_2 = view.findViewById(R.id.step_text2);
        Step_text_3 = view.findViewById(R.id.step_text3);

        change(Step_text_0,getActivity());
        change(Step_text_1,getActivity());
        change(Step_text_2,getActivity());
        change(Step_text_3,getActivity());

        photo_text = view.findViewById(R.id.photo_text);
        photo_text1 = view.findViewById(R.id.photo_text1);
        photo_text2 = view.findViewById(R.id.photo_text2);
        photo_text3 = view.findViewById(R.id.photo_text3);


        change(photo_text,getActivity());
        change(photo_text1,getActivity());
        change(photo_text2,getActivity());
        change(photo_text3,getActivity());

        heartPicture = view.findViewById(R.id.heartpicture);
        stepPicture = view.findViewById(R.id.step_picture);
        bmiPicture = view.findViewById(R.id.bmi_picture);
        circleImageView = view.findViewById(R.id.circleImageView);
        photoPicture = view.findViewById(R.id.photoImage);
        photoImage_1 = view.findViewById(R.id.photoImage_1);

        heartPicture_1 = view.findViewById(R.id.heartpicture1);
        stepPicture_1 = view.findViewById(R.id.step_picture1);
        photoImage_2 = view.findViewById(R.id.photoImage2);
        photoImage_3 = view.findViewById(R.id.photoImage_3);
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
        heartCard = view.findViewById(R.id.heart);
        photoCardView = view.findViewById(R.id.photoCardView);
        mConstraintLayout = view.findViewById(R.id.constraint);
        touchbmi = view.findViewById(R.id.touchbmi);
        photoCardView1 = view.findViewById(R.id.photoCardView1);
        stepCard = view.findViewById(R.id.step);
        stepCard1 = view.findViewById(R.id.step1);
        heartCard = view.findViewById(R.id.heart);
        heartCard1 = view.findViewById(R.id.heart1);
        mViewPager2 = requireActivity().findViewById(R.id.viewpager2);
        isIcallback(mViewPager2);

        eye_button.setOnClickListener(this);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        photoCardView.setOnClickListener(this);
        bmiCard.setOnClickListener(this);
        photoCardView1.setOnClickListener(this);
        touchbmi.setOnClickListener(this);
        stepCard1.setOnClickListener(this);
        stepCard.setOnClickListener(this);
        heartCard.setOnClickListener(this);
        heartCard1.setOnClickListener(this);

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

    private void isIcallback(ViewPager2 viewPager2) {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                // 在此处设置 ViewPager2 是否可滑动
                viewPager2.setUserInputEnabled(isViewPagerScrollEnabled);
            }
        });
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


        if(v.getId()==R.id.photoCardView||v.getId()==R.id.photoCardView1){
            Intent intent = new Intent(getActivity(),PhotoActivity.class);
            String a = "photo";
            intent.putExtra("photo",a);
            startActivity(intent);
        }
        //点击bmiCard,进入界面输入身高体重
        if(v.getId()==R.id.bmicard){
            bmiCard.setVisibility(v.GONE);
            stepCard.setVisibility(v.GONE);
            heartCard.setVisibility(v.GONE);
            photoCardView.setVisibility(v.GONE);

            touchbmi.setVisibility(v.VISIBLE);
            stepCard1.setVisibility(v.VISIBLE);
            heartCard1.setVisibility(v.VISIBLE);
            photoCardView1.setVisibility(v.VISIBLE);



        }
        if(v.getId()==R.id.touchbmi){
            bmiCard.setVisibility(v.VISIBLE);
            stepCard.setVisibility(v.VISIBLE);
            heartCard.setVisibility(v.VISIBLE);
            photoCardView.setVisibility(v.VISIBLE);

            touchbmi.setVisibility(v.GONE);
            stepCard1.setVisibility(v.GONE);
            heartCard1.setVisibility(v.GONE);
            photoCardView1.setVisibility(v.GONE);
        }
        if(v.getId()==R.id.step||v.getId()==R.id.step1){
            Intent intent = new Intent(getActivity(), WalkActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.heart||v.getId()==R.id.heart1){
            Intent intent = new Intent(getActivity(), HeartActivity.class);
            startActivity(intent);
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
