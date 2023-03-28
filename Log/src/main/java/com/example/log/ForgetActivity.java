package com.example.log;
import static Util.changeTime.changeTime_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private EditText mEditText_0;
    private EditText password_0;
    private EditText password_1;
    private EditText email;
    private TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forget);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        init();
    }
    private void init(){
        mButton = findViewById(R.id.button);
        mEditText_0 = findViewById(R.id.email);
        email = findViewById(R.id.word);
        time = findViewById(R.id.time);
        password_0 = findViewById(R.id.password);
        password_1 = findViewById(R.id.repassword);
        mButton.setOnClickListener(this);
        time.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button){
            forget();
            Toast.makeText(this,"修改密码成功",Toast.LENGTH_SHORT).show();
            finish();
        }
        else if(view.getId()==R.id.time){
            changeTime();
        }
    }
    private void forget(){
        String email_num = mEditText_0.getText().toString();
        String num = email.getText().toString();
        String password_One = password_0.getText().toString();
        String password_Two = password_1.getText().toString();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if(!password_One.equals(password_Two)){
                    Toast.makeText(ForgetActivity.this,"两次密码输入的不同", Toast.LENGTH_LONG).show();
                }
                else if(email_num.length()==0||num.length()==0||password_One.length()==0||password_Two.length()==0){
                    Toast.makeText(ForgetActivity.this,"不能为空",Toast.LENGTH_SHORT).show();

                }
                else{
                    OkHttpClient okHttpClient = new OkHttpClient();
                    FormBody formBody = new FormBody.Builder().add("verify",num).add("email",email_num).
                            add("password",password_One).build();
                    Request request = new Request.Builder().
                            url("http://史国华是帅哥.com:1234/PutUserMsg/rePassVerify").put(formBody)
                            .build();
                    Response response = null;
                    try {
                        response = okHttpClient.newCall(request).execute();
                        if(response.isSuccessful()){
                            Log.d("response2323","密码成功修改");
                        }
                        else{
                            Log.d("response2323","密码修改失败");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
        thread.start();


    }
    private void changeTime(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String email_num = mEditText_0.getText().toString();
                Log.d("response2323","email "+email_num);
                changeTime_1(time,ForgetActivity.this);
                if(email_num.length()==0){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ForgetActivity.this,"邮箱号不能为空",Toast.LENGTH_SHORT).show();
                        }
                    });

                }else {
                        OkHttpClient okHttpClient = new OkHttpClient();
                        RequestBody requestBody = new FormBody.Builder().add( "email",email_num).build();
                        Log.d("response2323","email"+email_num);
                        Request request = new Request.Builder().url("http://史国华是帅哥.com:1234/PutUserMsg/rePassSendVerify").put(requestBody).build();
                        Response response = null;
                        try {
                            response = okHttpClient.newCall(request).execute();
                            if(response.isSuccessful()){
                                Log.d("response2323","新验证嘛"+response.body().string());
                            }
                            else{
                                Log.d("response2323","验证码失败"+response.body().string());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                }
            }
        });
        thread.start();
    }
}