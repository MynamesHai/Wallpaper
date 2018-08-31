package com.androidvn.wallpaper.ui.trending.news.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.data.model.news.NewData;
import com.androidvn.wallpaper.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<NewData> listWallpaper = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wallpaper, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return listWallpaper.size();
    }

    public void addItemsWallpaper(List<NewData> listNewWallpaper) {
        this.listWallpaper.clear();
        this.listWallpaper.addAll(listNewWallpaper);
        notifyDataSetChanged();
    }

    public class NewHolder extends BaseViewHolder{

        public NewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void clear() {
            //todo clear view
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            //todo update item view.
        }
    }
}
