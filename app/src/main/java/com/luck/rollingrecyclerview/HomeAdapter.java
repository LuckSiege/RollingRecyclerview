package com.luck.rollingrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author：luck
 * project：BeverageWholesale
 * package：com.ttouch.beveragewholesale.adapter
 * email：893855882@qq.com
 * data：16/12/8
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.DefaultViewHolder> {
    private Context mContext;

    public HomeAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    @Override
    public DefaultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new DefaultViewHolder(root);
    }

    @Override
    public void onBindViewHolder(final DefaultViewHolder holder, final int position) {

    }

    class DefaultViewHolder extends RecyclerView.ViewHolder {

        public DefaultViewHolder(View itemView) {
            super(itemView);
        }
    }
}
