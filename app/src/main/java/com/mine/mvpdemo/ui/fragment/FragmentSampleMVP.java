package com.mine.mvpdemo.ui.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mine.mvpdemo.R;
import com.mine.mvpdemo.presenter.DemoContract;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSampleMVP extends Fragment implements DemoContract.View {

    private Button btnSum;
    private TextView tvTotal;
    private DemoContract.Presenter mPresenter;

    public static FragmentSampleMVP newInstance() {
        return new FragmentSampleMVP();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample_mv, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUi();
        registerListener();
    }



    private void registerListener() {
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.AddNumerals(10,20);
            }
        });
    }

    private void initUi() {
        View view =getView();
        btnSum = view.findViewById(R.id.btnSum);
        tvTotal = view.findViewById(R.id.tvTotal);

    }



    @Override
    public void sumNumerals(int sum) {
        tvTotal.setText("");
        Toast.makeText(getContext(), "Calculating sum", Toast.LENGTH_SHORT).show();
        tvTotal.setText("10 + 20 = "+sum);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setPresenter(DemoContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
