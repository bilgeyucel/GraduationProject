package com.example.grad;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;


public class PrintViewModel extends ViewModel {

    public static final String BUNDLE_KEY = "com.example.grad.printSolution";

    private MutableLiveData<String> liveSolution;

    public PrintViewModel() {
        liveSolution = new MutableLiveData<>();
        liveSolution.setValue("");
    }

    public MutableLiveData<String> getLiveSolution() {
        return liveSolution;
    }

    public void setSolution(String c) {
        liveSolution.setValue(c);
    }

//    public String getCount(){
//        return liveSolution.getValue();
//    }
    public void writeToBundle(Bundle bundle) {
        bundle.putString(BUNDLE_KEY, getLiveSolution().getValue());
    }

    public void readFromBundle(Bundle bundle) {
        setSolution(bundle.getString(BUNDLE_KEY));
    }
}
