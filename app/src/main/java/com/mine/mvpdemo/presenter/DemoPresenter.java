package com.mine.mvpdemo.presenter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import static android.support.v4.util.Preconditions.checkNotNull;

public class DemoPresenter implements DemoContract.Presenter {

    private DemoContract.View mDemoview;

    @SuppressLint("RestrictedApi")
    public DemoPresenter(@NonNull DemoContract.View demoview){
        mDemoview = demoview;
        mDemoview = checkNotNull(demoview," DemoContract.View cannot be null");
        mDemoview.setPresenter(this);
    }

    @Override
    public void AddNumerals(int a, int b) {
        int sum = a+b;
        mDemoview.sumNumerals(sum);
    }

    @Override
    public void start() {

    }
}
