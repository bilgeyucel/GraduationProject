package com.example.grad;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;


public class CorrectViewModel extends ViewModel {

    public static final String BUNDLE_KEY = "com.example.grad.correctSudoku";

    private MutableLiveData<String> liveRecognized;

    public CorrectViewModel() {
        liveRecognized = new MutableLiveData<>();
        liveRecognized.setValue("");
    }

    public MutableLiveData<String> getliveRecognized() {
        return liveRecognized;
    }

    public void setRecognized(String c) {
        liveRecognized.setValue(c);
    }

    //    public String getCount(){
//        return liveSolution.getValue();
//    }
    public void writeToBundle(Bundle bundle) {
        bundle.putString(BUNDLE_KEY, getliveRecognized().getValue());
    }

    public void readFromBundle(Bundle bundle) {
        setRecognized(bundle.getString(BUNDLE_KEY));
    }
}
