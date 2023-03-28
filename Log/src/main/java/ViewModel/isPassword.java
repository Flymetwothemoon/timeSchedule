package ViewModel;

import androidx.lifecycle.ViewModel;

public class isPassword extends ViewModel {
    public String passwordOne;
    public void setPasswordOne(String passwordOne){
        this.passwordOne = passwordOne;
    }
    public boolean isPasswordOne(String passwordOne){
        boolean a = false;
        if(this.passwordOne.equals(passwordOne)){
            a = true;

        }
        return a;
    }
}
