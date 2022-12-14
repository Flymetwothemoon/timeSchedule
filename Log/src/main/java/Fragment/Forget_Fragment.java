package Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.log.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Forget_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@Route(path = "/logon/logon1")
public class Forget_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    private EditText number;
    private EditText password;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button mButton;
    public Forget_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Forget_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Forget_Fragment newInstance(String param1, String param2) {
        Forget_Fragment fragment = new Forget_Fragment();
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
            view = inflater.inflate(R.layout.fragment_forget_, container, false);
        }
        init();
        return view;
    }
    private void init(){
        number = view.findViewById(R.id.number_edit);
        password = view.findViewById(R.id.password_edit1);
        mButton = view.findViewById(R.id.Logon_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/main/main1").navigation();
            }
        });
    }
}