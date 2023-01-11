package com.example.module_mine.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibs.LogService;
import com.example.baselibs.ServiceFactory;
import com.example.module_mine.Activity.Module_MineActivity;
import com.example.module_mine.R;

import Service.EnterService;
import Service.ServiceUtil;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link manageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class manageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    public manageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment manageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static manageFragment newInstance(String param1, String param2) {
        manageFragment fragment = new manageFragment();
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
        if(view ==null) {
            view = inflater.inflate(R.layout.fragment_manage, container, false);
        }
        init();

        return view;
    }
    private void init(){
        ServiceUtil.press = true;
        ServiceFactory.getInstance().setLogService(new EnterService(ServiceUtil.press));
        ARouter.getInstance().build("/log/log1").navigation();
        Log.d("TAG0","这里的"+String.valueOf(ServiceFactory.getInstance().getLogService().press()));
        getActivity().finish();

    }
}