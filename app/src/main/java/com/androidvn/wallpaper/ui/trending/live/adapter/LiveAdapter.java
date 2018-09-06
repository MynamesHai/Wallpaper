package com.androidvn.wallpaper.ui.trending.live.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.data.model.news.NewData;
import com.androidvn.wallpaper.ui.base.BaseViewHolder;
import com.androidvn.wallpaper.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LiveAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context mContext;
    private List<NewData> listWallpaper = new ArrayList<>();

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new LiveHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_wallpaper,parent,false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return listWallpaper.size();
    }

    public void addItemsWallpaper(List<NewData> listLiveWallpaper) {
        this.listWallpaper.clear();
        this.listWallpaper.addAll(listLiveWallpaper);
        notifyDataSetChanged();
    }

    public class LiveHolder extends BaseViewHolder {
        private ImageView imgItemWallpaper;
        public LiveHolder(View itemView) {
            super(itemView);
            imgItemWallpaper = (ImageView) itemView.findViewById(R.id.img_item_wallpaper);
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            Utils.loadImageWithGlide(mContext, listWallpaper.get(position).thumbnailUrl, imgItemWallpaper);
        }
    }
}
