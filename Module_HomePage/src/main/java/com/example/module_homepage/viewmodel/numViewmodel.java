package com.example.module_homepage.viewmodel;

import androidx.lifecycle.ViewModel;

public class numViewmodel extends ViewModel {
    int count = 0;
    public void init(int count){
        this.count = count;
    }
}
