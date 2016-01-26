package com.sidiq.sampleobserver.application;

import android.app.Application;

import com.sidiq.sampleobserver.observable.ChangesObservable;

/**
 * Created by Sidiq on 26/01/2016.
 */
public class SampleObserverApplication extends Application{
    private ChangesObservable mChangesObservable;

    @Override
    public void onCreate() {
        super.onCreate();
        mChangesObservable = new ChangesObservable();
    }

    public ChangesObservable getChangesObservable(){
        return mChangesObservable;
    }
}
