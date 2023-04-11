package com.example.module_homepage.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.module_homepage.R;
import com.example.module_homepage.adapter.name;
import com.example.module_homepage.adapter.nameAdapter;
import com.example.module_homepage.utils.sendOkHttp;
import com.example.module_homepage.viewmodel.numViewmodel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class EnterActivity extends AppCompatActivity {
    private EditText search;
    private RecyclerView searchRecycler;
    private List<name>mList = new ArrayList<>();
    numViewmodel numViewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏 如电量 wifi等
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_enter);
        search();
    }
    private void search(){
        search = findViewById(R.id.editText);
        searchRecycler = findViewById(R.id.search_recycler);
         numViewmodel = new ViewModelProvider(this).get(numViewmodel.class);
        nameAdapter adapter = new nameAdapter(mList,EnterActivity.this);
        int cnt1 = 0;
        int cnt2 = 0;
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String query = charSequence.toString().trim();

                    boolean wha = false;
                    Log.d("wode",search.getText().toString());
                    if(search.getText().toString().equals(null)){
                        wha = true;
                    }
                    sendOkHttp sendOkHttp = new sendOkHttp();
                    sendOkHttp.send(query, 0, mList, adapter, EnterActivity.this,wha);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        searchRecycler.setLayoutManager(new LinearLayoutManager(EnterActivity.this));
        searchRecycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new nameAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(EnterActivity.this,GetActivity.class);
                String id = mList.get(position).nameId;
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }
}