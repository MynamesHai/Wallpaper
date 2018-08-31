package com.androidvn.wallpaper.ui.trending.news.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.androidvn.wallpaper.data.model.news.NewData;
import com.androidvn.wallpaper.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<NewData> listWallpaper = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listWallpaper.size();
    }

    public void addItemsWallpaper(List<NewData> listNewWallpaper) {
        this.listWallpaper = listNewWallpaper;
        notifyDataSetChanged();
    }
}
