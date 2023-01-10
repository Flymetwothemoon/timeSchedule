package com.example.module_mine.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.module_mine.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link pictureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pictureFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    public pictureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment pictureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static pictureFragment newInstance(String param1, String param2) {
        pictureFragment fragment = new pictureFragment();
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
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_picture, container, false);
        }
        init();
        return view;
    }
    private void init(){
        Button button_0 = view.findViewById(R.id.open_album);
        Button button_1 = view.findViewById(R.id.alum_save);
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.open_album){

        }
        if(v.getId()==R.id.alum_save){
            
        }
    }
}