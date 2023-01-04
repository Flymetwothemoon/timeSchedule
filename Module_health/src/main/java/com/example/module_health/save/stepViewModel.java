package com.example.module_health.save;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Insert;

import java.util.List;

public class stepViewModel extends ViewModel {
    public MutableLiveData<Integer>mLiveData = new MutableLiveData();
    stepRepository mStepRepository;
    private final LiveData<List<step>> mAllStep;
    public stepViewModel(@NonNull Application application) {
        mStepRepository = new stepRepository(application);
        mAllStep = mStepRepository.mAllStep;
    }
    public void insert(step step){
        mStepRepository.insert(step);
    }
    public void updata(step step){
        mStepRepository.updata(step);
    }
    LiveData<List<step>>getAllSteps(){
        return mAllStep;
    }
}
