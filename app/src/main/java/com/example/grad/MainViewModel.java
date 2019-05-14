package com.example.grad;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;


public class MainViewModel extends ViewModel {

    public static final String MAIN_BUNDLE_KEY = "com.example.grad.main";

    MutableLiveData<String> liveSolution;

    public MainViewModel() {
        liveSolution = new MutableLiveData<>();
        liveSolution.setValue("0");
    }

    public MutableLiveData<String> getLiveSolution() {
        return liveSolution;
    }

//    public String getInteger(){
//        return liveSolution.getValue();
//    }

    public void setSolution(String rating) {
        liveSolution.setValue(rating);
    }

    public void writeToBundle(Bundle bundle) {
        bundle.putString(MAIN_BUNDLE_KEY, liveSolution.getValue());
    }

    public void readFromBundle(Bundle bundle) {
        bundle.getString(MAIN_BUNDLE_KEY);
    }
}
