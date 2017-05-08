package com.example.pangxinlong.negativescreen;

import com.example.mylibrary.NewListView;
import com.example.mylibrary.NewsListFragment;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_search)
    EditText mEtSearch;

    @BindView(R.id.iv_app)
    ImageView mIvApp;

    @BindView(R.id.activity_main)
    RelativeLayout mActivityMain;

    @BindView(R.id.fl_load_view)
    FrameLayout mFlLoadView;

    private NewsListFragment mNewsListFragment;

    private NewListView mNewListView;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mFlLoadView.addView(NewListView.instance(this).sdk());

//        mNewsListFragment=new NewsListFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fl_load_view, mNewsListFragment);
//        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
