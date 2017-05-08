package com.example.mylibrary;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pxl on 2017/5/7.
 */

public class NewListView implements BaseView {


    private Context mContext;

    private View mRootView;

    SwipeRefreshLayout mSrList;

    RecyclerView mRvList;

    private NewsAdapter mNewsAdapter;

    private List<String> mDataList;

    private static NewListView mNewListView;

    public static NewListView instance(Context context) {
        if (mNewListView == null) {
            mNewListView = new NewListView(context);
        }
        return mNewListView;
    }

    private NewListView(Context context) {
        mContext = context;
        mRootView = LayoutInflater.from(context).inflate(R.layout.fragment_news_list, null);
        initView();
        initData();
    }

    @Override
    public View sdk() {
        return mRootView;
    }


    private void initView() {
        mSrList = (SwipeRefreshLayout) mRootView.findViewById(R.id.sr_list);
        mRvList = (RecyclerView) mRootView.findViewById(R.id.rv_list);

        mSrList.setEnabled(false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRvList.setLayoutManager(layoutManager);

        mNewsAdapter = new NewsAdapter(mContext);
        mRvList.setAdapter(mNewsAdapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDataList.add(i + "");
        }
        mNewsAdapter.setData(mDataList);
    }

}
