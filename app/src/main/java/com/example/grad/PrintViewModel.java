package com.example.grad;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;


public class PrintViewModel extends ViewModel {

    public static final String BUNDLE_KEY = "com.example.grad.print";

    private MutableLiveData<String> liveCount;

    public PrintViewModel() {
        liveCount = new MutableLiveData<>();
        liveCount.setValue("nulllll");
    }

    public MutableLiveData<String> getLiveCount() {
        return liveCount;
    }

    public void setCount(String c) {
        liveCount.setValue(c);
    }

    public String getCount(){
        return liveCount.getValue();
    }
    public void writeToBundle(Bundle bundle) {
        bundle.putString(BUNDLE_KEY, liveCount.getValue());
    }

    public void readFromBundle(Bundle bundle) {
        setCount(bundle.getString(BUNDLE_KEY));
    }
}
