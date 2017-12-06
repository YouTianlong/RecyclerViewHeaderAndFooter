package com.bm.recyclerviewheaderandfooter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by youtl on 2017/11/30.
 */

public class WarpAdapter extends RecyclerView.Adapter {

    private static final String TAG = WarpAdapter.class.getSimpleName();
    private List<View> mHeaderViews;
    private List<View> mFooterViews;
    private RecyclerView.Adapter mAdapter;
    private static final int HEADER_TYPE = 10000;
    private static final int NORMAL_TYPE = 20000;
    private static final int FOOTER_TYPE = 30000;
    private Context context;

    public WarpAdapter(Context context, RecyclerView.Adapter adapter, List<View> headerViews, List<View> footerViews){
        this.context = context;
        mAdapter = adapter;

        this.mHeaderViews = headerViews;
        this.mFooterViews = footerViews;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (NORMAL_TYPE > viewType && HEADER_TYPE <= viewType){
            //  is header
            View view = mHeaderViews.get(viewType - HEADER_TYPE);
            return new WarpHolder(view);
        }else if (FOOTER_TYPE <= viewType){
            // is footer
            View view = mFooterViews.get(viewType - FOOTER_TYPE - mAdapter.getItemCount() - mHeaderViews.size());
            return new WarpHolder(view);
        }
        return mAdapter.onCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (HEADER_TYPE == getItemViewType(position)){

        }else if (NORMAL_TYPE == getItemViewType(position)){
            mAdapter.onBindViewHolder(holder,position - mHeaderViews.size());
        }else if (FOOTER_TYPE == getItemViewType(position)){

        }
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount() + mHeaderViews.size() + mFooterViews.size();
    }

    public void addHeaderView(View headerView){
        mHeaderViews.add(headerView);
    }

    public void addFooterView(View footerView){
        mFooterViews.add(footerView);
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mHeaderViews.size()){
            return HEADER_TYPE + position;
        }else if (position >= mHeaderViews.size() + mAdapter.getItemCount()){
            return FOOTER_TYPE + position;
        }
        return NORMAL_TYPE;
    }

    class WarpHolder extends RecyclerView.ViewHolder{

        public WarpHolder(View itemView) {
            super(itemView);
        }

        public View getView(int id){
            return itemView.findViewById(id);
        }
    }
}
