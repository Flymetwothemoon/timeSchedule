package com.example.module_health.fragment;

import static Utils.changeTextStyle.change_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.TestLooperManager;
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
        mButton = mView.findViewById(R.id.button);
        change_2(mTextView_0,getActivity());
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), TestActivity.class);
        v.getContext().startActivity(intent);
    }
}