package com.example.andy1729.a02_hideonscrolltoolbar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andy1729.a02_hideonscrolltoolbar.R;
import com.example.andy1729.a02_hideonscrolltoolbar.adapter.viewholder.RecyclerItemViewHolder;

import java.util.List;

/**
 * Created by andy1729 on 26/7/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mItemList;

    public RecyclerAdapter(List<String> ItemList) {
        mItemList = ItemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return RecyclerItemViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerItemViewHolder holder = (RecyclerItemViewHolder) viewHolder;
        String itemText = mItemList.get(position);
        holder.setItemText(itemText);
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }
}