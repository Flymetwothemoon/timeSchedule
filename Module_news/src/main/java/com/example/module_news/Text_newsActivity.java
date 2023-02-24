package com.example.module_news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;


//消息内容的具体展示界面
public class Text_newsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imageView;
    private TextView title;
    private TextView content;
    private int number;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_news);

        myViewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);

        toolbar= (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        imageView=(ImageView) findViewById(R.id.back);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        number=bundle.getInt("test");

        title=(TextView)findViewById(R.id.text_title);
        content=(TextView)findViewById(R.id.text_content);
        title.setText(myViewModel.titleArray[number]);
        content.setText(myViewModel.textArray[number]);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    //这两个menu方法重写是给toolbar上的menu写的
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.delete) {
            Toast.makeText(Text_newsActivity.this, "delete", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}