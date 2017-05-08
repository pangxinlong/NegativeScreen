package com.example.mylibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pxl on 2017/5/7.
 */

public class NewsListFragment extends Fragment {

    //    @BindView(R.id.sr_list)
    SwipeRefreshLayout mSrList;

    //    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private NewsAdapter mNewsAdapter;

    private Unbinder mUnbinder;

    private List<String> mDataList;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_news_list, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        setListener();
    }

    private void initView() {
        mSrList = (SwipeRefreshLayout) rootView.findViewById(R.id.sr_list);
        mRvList = (RecyclerView) rootView.findViewById(R.id.rv_list);

        mSrList.setEnabled(false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRvList.setLayoutManager(layoutManager);

        mNewsAdapter = new NewsAdapter(getActivity());
        mRvList.setAdapter(mNewsAdapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDataList.add(i + "");
        }
        mNewsAdapter.setData(mDataList);
    }

    private void setListener(){
        mSrList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        mRvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
