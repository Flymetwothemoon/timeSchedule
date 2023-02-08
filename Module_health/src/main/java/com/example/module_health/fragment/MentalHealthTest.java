package com.example.module_health.fragment;

import static Utils.changeTextStyle.change_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.TestLooperManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.module_health.Activity.TestActivity;
import com.example.module_health.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MentalHealthTest#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MentalHealthTest extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView mTextView_0;
    private View mView;
    private Button mButton;
    public MentalHealthTest() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MentalHealthTest.
     */
    // TODO: Rename and change types and number of parameters
    public static MentalHealthTest newInstance(String param1, String param2) {
        MentalHealthTest fragment = new MentalHealthTest();
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
        if(mView==null){
        mView= inflater.inflate(R.layout.fragment_mental_health_test, container, false);
        }
        init();
        return mView;
    }
    private void init(){
        mTextView_0 = mView.findViewById(R.id.text_0);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = mView.getContext().getSharedPreferences("bmi", Context.MODE_PRIVATE);
                int mental_0 = sharedPreferences.getInt("mental_0",0);
                int mental_1 = sharedPreferences.getInt("mental_1",0);
                int mental_2 = sharedPreferences.getInt("mental_2",0);
                int mental_3 = sharedPreferences.getInt("mental_3",0);
                int mental_4 = sharedPreferences.getInt("mental_4",0);
                sum(mental_0,mental_1,mental_2,mental_3,mental_4);
            }
        });

        mButton = mView.findViewById(R.id.button);
        change_2(mTextView_0,getActivity());
        mButton.setOnClickListener(this);
    }
    private void sum( int mental_0, int mental_1, int mental_2, int mental_3, int mental_4){
        int sum_0 = mental_0+mental_1+mental_2+mental_3+mental_4;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(sum_0<0){
                    mTextView_0.setText("每个人都有可能陷入困境之中，如果能够意识到你身边有这么多的人，都和你一样，身处困境之中，想要求一个出路而遍寻不到的时候，你就会发现，原来生活中有这么多的朋友，他们也正努力寻找出口。");
                }
                else if(sum_0==0){
                    mTextView_0.setText("健康不仅仅代表着身体健康,也代表着心理健康,来试着进行下面的测试吧!");
                }
                else if(sum_0==1){
                    mTextView_0.setText("或许你在尝试一件新的事情，却失败了；或许在遇到一个新的人，却相处不友好；去到一个新的环境之后，却适应不了，又走了；或许被最爱的人抛弃了，觉得痛苦不已。");
                }
                else if(sum_0==2){
                    mTextView_0.setText("这些人生中的阴霾，有人能够很快抛在脑后，而有人却入了心，从此跌入泥泞的沼泽之中，不管多努力都再也爬不上来。");
                }
                else if(sum_0==3){
                    mTextView_0.setText("　没有完美的人生，曲折之路，风景也照样好看" +
                            "就算身处困难之中，就算身处逆境的泥沼，就算没有任何一个人帮自己，那就怎样！");
                }
                else if(sum_0==4){
                    mTextView_0.setText("人生无须过于执着，尽人事安天命而已。选择了，努力了，坚持了，走过了，无愧于心就好，至于结果如何，实际上并不重要。顺其自然、随遇而安，如行云般自在，像流水般洒脱，才是人生应有的态度。");
                }
                else {
                    mTextView_0.setText("开朗的性格不仅仅能够使自己经常坚持心境的愉快，并且能够感染你周围的人们，使他们也觉得人生充满了和谐与光明。");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), TestActivity.class);
        v.getContext().startActivity(intent);
    }
}