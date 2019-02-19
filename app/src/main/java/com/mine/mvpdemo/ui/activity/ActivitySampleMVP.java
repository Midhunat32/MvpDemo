package com.mine.mvpdemo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mine.mvpdemo.R;
import com.mine.mvpdemo.presenter.DemoContract;
import com.mine.mvpdemo.presenter.DemoPresenter;
import com.mine.mvpdemo.ui.fragment.FragmentSampleMVP;
import com.mine.mvpdemo.utils.ActivityUtils;

public class ActivitySampleMVP extends AppCompatActivity {

    private DemoPresenter mDemoPresenter;
    private FragmentSampleMVP tasksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initUi();
        registerListeners();
        loadFragment();
        initObjects();

    }

    private void loadFragment() {
         tasksFragment = (FragmentSampleMVP) getSupportFragmentManager()
                 .findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            tasksFragment = FragmentSampleMVP.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    tasksFragment, R.id.contentFrame);
        }
    }

    private void registerListeners() {

    }

    private void initUi() {

    }

    private void initObjects() {
        mDemoPresenter = new DemoPresenter(tasksFragment);
    }
}
