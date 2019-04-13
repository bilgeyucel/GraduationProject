package com.example.grad;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;


public class MainViewModel extends ViewModel {

    public static final String MAIN_BUNDLE_KEY = "com.example.grad.main";

    MutableLiveData<String> liveRating;

    public MainViewModel() {
        liveRating = new MutableLiveData<>();
        liveRating.setValue("0");
    }

    public MutableLiveData<String> getLiveRating() {
        return liveRating;
    }

    public String getInteger(){
        return liveRating.getValue();
    }

    public void setRating(String rating) {
        liveRating.setValue(rating);
    }

    public void writeToBundle(Bundle bundle) {
        bundle.putString(MAIN_BUNDLE_KEY, liveRating.getValue());
    }

    public void readFromBundle(Bundle bundle) {
        setRating(bundle.getString(MAIN_BUNDLE_KEY));
    }
}
