package com.example.andy1729.a02_hideonscrolltoolbar;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andy1729.a02_hideonscrolltoolbar.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy1729 on 26/7/16.
 */
public class HideOnScrollFragment extends android.support.v4.app.Fragment {
    public final static String ITEMS_COUNT_KEY = "HideOnScrollFragment$ItemsCount";

    public static HideOnScrollFragment createInstance(int itemsCount) {
        HideOnScrollFragment hideOnScrollFragment = new HideOnScrollFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ITEMS_COUNT_KEY, itemsCount);
        hideOnScrollFragment.setArguments(bundle);
        return hideOnScrollFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                                        R.layout.fragment_main, container, false);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(createItemList());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private List<String> createItemList() {
        List<String> itemList = new ArrayList<>();
        Bundle bundle = getArguments();
        if(bundle != null) {
            int itemsCount = bundle.getInt(ITEMS_COUNT_KEY);
            for(int i =0;i < itemsCount; i++) {
                itemList.add("List " + i);
            }
        }
        return itemList;
    }
}
