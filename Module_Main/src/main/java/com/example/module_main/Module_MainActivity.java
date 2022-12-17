package com.example.module_main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

@Route(path = "/main/main1")
public class Module_MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView  navigationView;
    private FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_main);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        button = findViewById(R.id.floating);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ARouter.getInstance().build("/direct/direct1").navigation();

            }
        });
        navigationView = findViewById(R.id.navagation);
        navigationView.setOnNavigationItemSelectedListener(this);

        navigationView.setSelectedItemId(R.id.homepage);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if(item.getItemId()==R.id.homepage){
            Fragment fragment = (Fragment) ARouter.getInstance().build("/homepage/homepage1").navigation();
            fragmentTransaction.replace(R.id.home_fragment, fragment).commit();
            return true;
        }
        if(item.getItemId()==R.id.health){
            Fragment fragment = (Fragment) ARouter.getInstance().build("/health/health1").navigation();
            fragmentTransaction.replace(R.id.home_fragment, fragment).commit();
            return true;
        }
//        if(item.getItemId()==R.id.directseeding){
//            Fragment fragment1 = (Fragment) ARouter.getInstance().build("/direct/direct1").navigation();
//            fragmentTransaction.replace(R.id.home_fragment, fragment1).commit();
//            return true;
//        }
        if(item.getItemId()==R.id.news){
            Fragment fragment = (Fragment) ARouter.getInstance().build("/news/news1").navigation();
            fragmentTransaction.replace(R.id.home_fragment, fragment).commit();
            return true;
        }
        if(item.getItemId()==R.id.mine){
            Fragment fragment = (Fragment) ARouter.getInstance().build("/mine/mine1").navigation();
            fragmentTransaction.replace(R.id.home_fragment, fragment).commit();
            return true;
        }

        return true;
    }
}
