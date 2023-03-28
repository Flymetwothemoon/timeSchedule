package com.example.log;

import static Util.changeTime.changeTime_0;

import androidx.appcompat.app.AppCompatActivity;

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


import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Objects;

import Json.ReMsg;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LogonActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView time;
    private EditText word;
    private EditText email;
    private EditText nickName;
    private EditText passWord;
    private Button mButton;
    private EditText rePassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logo);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        init();

    }
    private void init(){
        time = findViewById(R.id.time);
        word = findViewById(R.id.word);
        nickName = findViewById(R.id.nickNameEdit);
        email = findViewById(R.id.email);
        passWord = findViewById(R.id.password);
        rePassWord = findViewById(R.id.repassword);
        mButton = findViewById(R.id.button);
        time.setOnClickListener(this);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.time){
            changeTime();
        }
        if(view.getId()==R.id.button){
            logonIn();
        }

    }
    private void logonIn(){
        String nickNAME = nickName.getText().toString();
        String email_Num = email.getText().toString();
        String Word_Num = word.getText().toString();
        String PassWord_Num = passWord.getText().toString();
        String rePassWord_Num = rePassWord.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences("token",MODE_PRIVATE).edit();
        if(nickNAME.length()>20){
            Toast.makeText(LogonActivity.this,"昵称过长",Toast.LENGTH_SHORT).show();
        }
        else if(PassWord_Num.length()>20){
            Toast.makeText(LogonActivity.this,"密码过长",Toast.LENGTH_SHORT).show();
        }
        else if(!PassWord_Num.equals(rePassWord_Num)){
            Toast.makeText(LogonActivity.this,"两次密码不同",Toast.LENGTH_SHORT).show();
        } else if (nickNAME.equals("") || (Word_Num.equals("")) || (rePassWord_Num.equals("")) || (email_Num.equals(""))) {
            Toast.makeText(LogonActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
        } else {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                   OkHttpClient okHttpClient = new OkHttpClient();
                    //邮箱号,验证码,密码,昵称
                    FormBody formBody = new FormBody.Builder().add("email",email_Num).add("verify",Word_Num)
                            .add("nickname",nickNAME).add("password",PassWord_Num).build();
                    Request request = new Request.Builder().post(formBody).url("http://史国华是帅哥.com:1234/verify").build();
                    Response response = null;

                    try {
                        response = okHttpClient.newCall(request).execute();
                        if(response.isSuccessful()){

                            Gson gson = new Gson();
                            Log.d("response2323", "new gson()");
                            ReMsg gson1 = gson.fromJson((response.body()).string(), ReMsg.class);
                            Log.d("response2323", "解析成功");
                            if(gson1.getCode().equals("OK_200")){
                                ARouter.getInstance().build("/main/main1").navigation();
                            }

//                            gson12 gson12 = gson.fromJson(response.body().string(), Json.gson12.class);
//                            if(gson12.code.equals("")){
//                                ARouter.getInstance().build("/main/main1").navigation();
//                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }


    private void changeTime(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                 String email_num = email.getText().toString();
                if(email_num.equals("")) {
                            if(LogonActivity.this==null){
                                return;
                            }
                            else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LogonActivity.this, "邮箱号不能为空", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }}
                        else {
                            changeTime_0(time, LogonActivity.this);

                            RequestBody requestBody = new FormBody.Builder().add("email", email_num).build();
                            Request request = new Request.Builder().url("http://史国华是帅哥.com:1234/register").post(requestBody).build();
                            Response response1 = null;
                            try {
                                response1 = okHttpClient.newCall(request).execute();
                                if (response1.isSuccessful()) {
                                    Log.d("response111", response1.body().string());
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }





//                String nickname = word.getText().toString();
//                RequestBody requestBody = new FormBody.Builder().add("nickname",nickname).build();
////                FormBody formBody = new FormBody.Builder().add().add().add().build();
//                //验证码
//                Request request = new Request.Builder().url("http://xn--xkrtorxh5dgxnjwm.com:1234/register").post(requestBody).build();
//                //验证码,邮箱,密码,两个密码
////                Request request1 = new Request.Builder().url().post(formBody).build();
//                Response response = null;
//                try {
//                    response = okHttpClient.newCall(request).execute();
//                    if(response.isSuccessful()){
//                        Log.d("response111",response.body().string());
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });
        thread.start();
    }
}