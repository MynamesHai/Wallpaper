package com.androidvn.wallpaper.ui.trending.popular.adapter;

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

public class PopularAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<NewData> listPopularWallpaper = new ArrayList<>();
    private Context mContext;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new PopularHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wallpaper, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return listPopularWallpaper.size();
    }

    public void addItemsWallpaper(List<NewData> listPopular) {
        this.listPopularWallpaper.clear();
        this.listPopularWallpaper.addAll(listPopular);
        notifyDataSetChanged();
    }

    public class PopularHolder extends BaseViewHolder {
        private ImageView imgItemWallPaper;

        public PopularHolder(View itemView) {
            super(itemView);
            imgItemWallPaper = (ImageView) itemView.findViewById(R.id.img_item_wallpaper);
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            Utils.loadImageWithGlide(mContext, listPopularWallpaper.get(position).thumbnailUrl, imgItemWallPaper);
        }
    }
}
