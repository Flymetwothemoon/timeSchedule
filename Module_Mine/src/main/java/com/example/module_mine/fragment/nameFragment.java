package com.example.module_mine.fragment;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.module_mine.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nameFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    public String name;
    private EditText name_text;
    private Button button;
    public nameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static nameFragment newInstance(String param1, String param2) {
        nameFragment fragment = new nameFragment();
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
        if(view==null) {
            view = inflater.inflate(R.layout.fragment_name, container, false);
        }
        init();

        return view;
    }
    private void init(){
        name_text = view.findViewById(R.id.name_text);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("TAG1","a");
        Intent replyIntent = new Intent();
        if(TextUtils.isEmpty(name_text.getText().toString())){
            getActivity().setResult(RESULT_CANCELED, replyIntent);
            Toast.makeText(getActivity(),"你什么都没有输入",Toast.LENGTH_SHORT).show();
        }//如果啥都没输入,那就什么也不传递
        else {
            name = name_text.getText().toString();
            replyIntent.putExtra("reply",name);
            getActivity().setResult(RESULT_OK, replyIntent);
            Toast.makeText(getActivity(),"修改成功",Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }//如果有输入的话

    }

}