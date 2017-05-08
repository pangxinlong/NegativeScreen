package com.example.mylibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pxl on 2017/5/7.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<String> dataList;

    private Context mContext;

    public NewsAdapter(Context context) {
        mContext = context;
        dataList = new ArrayList<>();
    }

    public void setData(List<String> list) {
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view) {
            mTvContent = (TextView) view.findViewById(R.id.tv_content);
        }

        public void setData(String content) {
            mTvContent.setText(content);
        }
    }
}
