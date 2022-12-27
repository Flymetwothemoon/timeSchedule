package Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.log.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Log_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@Route(path = "/log2/log3")
public class Log_Fragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText account;
    private EditText password;
    private Button log;
    private TextView email;
    private TextView logon;
    private TextView forget;
    public Log_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Log_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Log_Fragment newInstance(String param1, String param2) {
        Log_Fragment fragment = new Log_Fragment();
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
           view =  inflater.inflate(R.layout.fragment_log_, container, false);
        }
        init();
        log.setOnClickListener(this);
        email.setOnClickListener(this);
        logon.setOnClickListener(this);
        forget.setOnClickListener(this);
        return view;
    }
    private void init(){
        account = view.findViewById(R.id.Account_edit);
        password = view.findViewById(R.id.password_edit);
        log = view.findViewById(R.id.Log_button);
        email = view.findViewById(R.id.text_email);
        logon = view.findViewById(R.id.login_text);
        forget = view.findViewById(R.id.text_forget);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.Log_button){
            ARouter.getInstance().build("/main/main1").navigation();
        }
        if(v.getId()==R.id.login_text) {
            Toast.makeText(view.getContext(),"按了",Toast.LENGTH_SHORT).show();
            getChildFragmentManager().beginTransaction().replace(R.id.framlayout,new Logon_Fragment()).commit();
        }
    }
    }
