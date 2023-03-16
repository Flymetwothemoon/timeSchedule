package com.example.module_health.MVVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class bmiViewModel extends ViewModel {
    public MutableLiveData<Float>height_num = new MutableLiveData<>();
    public MutableLiveData<Float>weight_num = new MutableLiveData<>();
    public MutableLiveData<Float>bmi = new MutableLiveData<>();

    public void setHeight_num(Float height){
        height_num.setValue(height);
    }
    public void setWeight_num(Float weight){
        this.weight_num.setValue(weight);
    }
    public void numBMI(MutableLiveData<Float>height_num,MutableLiveData<Float>weight_num){
        Float num;
        if(height_num.getValue()!=null&&weight_num.getValue()!=null) {
            if (height_num.getValue() == 0.0F) {
                bmi.setValue(0.0F);
            } else {
                num = weight_num.getValue() / ((height_num.getValue()/100) * (height_num.getValue()/100));
                bmi.setValue(num);
            }
        }
    }
}
