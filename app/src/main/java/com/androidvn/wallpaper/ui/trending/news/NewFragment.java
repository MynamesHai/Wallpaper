package com.androidvn.wallpaper.ui.trending.news;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.data.model.news.NewData;
import com.androidvn.wallpaper.ui.base.BaseFragment;
import com.androidvn.wallpaper.ui.trending.news.adapter.NewAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class NewFragment extends BaseFragment implements NewMvp {

    @BindView(R.id.rv_news_wallpaper)
    RecyclerView rvNewsWallpaper;
    @BindView(R.id.swipe_layout_new)
    SwipeRefreshLayout swipeLayoutNew;

    @Inject
    NewAdapter newAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;

    public static NewFragment newInstance(){
        NewFragment fragment = new NewFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wallpaper_new;
    }

    @Override
    public void onCreateView() {
        initRecycleViews();
    }

    @Override
    public void setActionForViews() {

    }

    private void initRecycleViews() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvNewsWallpaper.setLayoutManager(mLayoutManager);
        rvNewsWallpaper.setItemAnimator(new DefaultItemAnimator());
        rvNewsWallpaper.setAdapter(newAdapter);
    }


    @Override
    public void setDataForViews(List<NewData> listNewWallpaper) {
        newAdapter.addItemsWallpaper(listNewWallpaper);
    }

}
