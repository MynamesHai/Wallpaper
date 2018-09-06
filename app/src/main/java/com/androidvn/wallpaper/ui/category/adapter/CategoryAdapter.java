package com.androidvn.wallpaper.ui.category.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.data.model.category.CategoryInfo;
import com.androidvn.wallpaper.ui.base.BaseViewHolder;
import com.androidvn.wallpaper.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<CategoryInfo> listCate = new ArrayList<>();
    private Context mContext;
    private int lastPosition = -1;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new MyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.fade_in
                        : R.anim.fade_in);
        holder.itemView.startAnimation(animation);
        lastPosition = position;

    }

    @Override
    public void onViewDetachedFromWindow(BaseViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public int getItemCount() {
        return listCate.size();
    }

    public void addItemsCate(List<CategoryInfo> listCate) {
        this.listCate.clear();
        this.listCate.addAll(listCate);
        notifyDataSetChanged();
    }


    public class MyViewHolder extends BaseViewHolder {
        private ImageView imgItemCate;
        private TextView tvItemCate;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgItemCate = (ImageView) itemView.findViewById(R.id.img_item_cate);
            tvItemCate = (TextView) itemView.findViewById(R.id.tv_item_cate);
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            Utils.loadImageWithGlide(mContext, listCate.get(position).categoryThumbnail, imgItemCate);
            tvItemCate.setText(listCate.get(position).getCategoryName());
        }
    }
}
