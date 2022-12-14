package com.example.module_main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

@Route(path = "/main/main1")
public class Module_MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView  navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_main);
        navigationView = findViewById(R.id.navagation);
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setSelectedItemId(R.id.home_fragment);
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
        if(item.getItemId()==R.id.directseeding){
            Fragment fragment1 = (Fragment) ARouter.getInstance().build("/direct/direct1").navigation();
            fragmentTransaction.replace(R.id.home_fragment, fragment1).commit();
            return true;
        }
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