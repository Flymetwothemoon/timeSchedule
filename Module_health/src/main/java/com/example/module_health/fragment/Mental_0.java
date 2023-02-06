package com.example.module_health.fragment;

import static Utils.changeTextStyle.change_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.module_health.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mental_0#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mental_0 extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View mView;
    private TextView mTextView;
    private Button no;
    private Button yes;
    public Mental_0() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mental_0.
     */
    // TODO: Rename and change types and number of parameters
    public static Mental_0 newInstance(String param1, String param2) {
        Mental_0 fragment = new Mental_0();
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
        if(mView==null) {
            mView= inflater.inflate(R.layout.fragment_mental_0, container, false);
        }
        init();
        return mView;
    }
    private void init(){

        mTextView = mView.findViewById(R.id.text_0);
        no = mView.findViewById(R.id.no);
        yes = mView.findViewById(R.id.yes);
        change_2(mTextView,getActivity());
        no.setOnClickListener(this);
        yes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.no){
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new Mental_1(), null)
                    .addToBackStack(null)
                    .commit();

        }
        if(v.getId()==R.id.yes){
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new Mental_1(), null)
                    .addToBackStack(null)
                    .commit();
        }
    }
}