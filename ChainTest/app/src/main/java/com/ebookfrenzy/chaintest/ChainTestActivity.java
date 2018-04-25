package com.ebookfrenzy.chaintest;

import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChainTestActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button btn1;

    @BindView(R.id.button2)
    Button btn2;

    @BindView(R.id.button3)
    Button btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain_test);
        ButterKnife.setDebug(BuildConfig.DEBUG);
        ButterKnife.bind(this);

    }

}
