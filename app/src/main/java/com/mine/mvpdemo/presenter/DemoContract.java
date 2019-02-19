package com.mine.mvpdemo.presenter;

import android.support.annotation.NonNull;

import com.mine.mvpdemo.BasePresenter;
import com.mine.mvpdemo.BaseView;

import java.util.List;

public interface DemoContract {

    interface View extends BaseView<Presenter> {

        void sumNumerals(int sum);

    }

    interface Presenter extends BasePresenter {

        void AddNumerals(int a,int b);

    }


}
