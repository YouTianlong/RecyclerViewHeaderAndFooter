package com.bm.recyclerviewheaderandfooter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youtl on 2017/11/30.
 */

public class EasyRecyclerView extends RecyclerView {

    private List<View> mHeaderViews;
    private List<View> mFooterViews;

    public EasyRecyclerView(Context context) {
        this(context,null);
    }

    public EasyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public EasyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mHeaderViews = new ArrayList<>();
        mFooterViews = new ArrayList<>();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        WarpAdapter warpAdapter = new WarpAdapter(getContext(),adapter,mHeaderViews,mFooterViews);
        super.setAdapter(warpAdapter);
    }

    public void addHeaderView(View headerView){
        mHeaderViews.add(headerView);
        WarpAdapter adapter = (WarpAdapter) getAdapter();
        if (adapter != null){
//            if (!(adapter instanceof WarpAdapter)){
//                adapter = new WarpAdapter(getContext(),adapter, mHeaderViews, mFooterViews);
//                setAdapter(adapter);
//            }
//            WarpAdapter warpAdapter = (WarpAdapter) adapter;
            adapter.notifyDataSetChanged();
        }
    }

    public void addFooterView(View footerView){
        mFooterViews.add(footerView);
        WarpAdapter adapter = (WarpAdapter) getAdapter();
        if (adapter != null){
            adapter.notifyDataSetChanged();
        }
    }
}
