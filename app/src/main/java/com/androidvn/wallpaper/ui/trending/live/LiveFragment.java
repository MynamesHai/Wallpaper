package com.androidvn.wallpaper.ui.trending.live;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.data.model.news.NewData;
import com.androidvn.wallpaper.ui.base.BaseFragment;
import com.androidvn.wallpaper.ui.main.MainActivity;
import com.androidvn.wallpaper.ui.trending.live.adapter.LiveAdapter;

import java.util.List;

import butterknife.BindView;

public class LiveFragment extends BaseFragment implements LiveMvp {

    @BindView(R.id.rv_live_wallpaper)
    RecyclerView rvLiveWallpaper;
    @BindView(R.id.swipe_layout_live)
    SwipeRefreshLayout swipeLayoutLive;

    private LivePresenter mPresenter;
    private Context mContext;
    private LiveAdapter liveAdapter;
    private LinearLayoutManager mLayoutManager;

    public static LiveFragment newInstances() {
        LiveFragment fragment = new LiveFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wallpaper_live;
    }

    @Override
    public void onCreateView() {
        mContext = getContext();
        mPresenter = new LivePresenter(mContext);
        mPresenter.attachView(this);
        initRecycleViews();
        mPresenter.doInGetLiveWallpaper();
    }

    @Override
    public void setActionForViews() {

    }

    @Override
    public void showBottomNavigationMenu() {
        ((MainActivity) mContext).getNavViewBottom().setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBottomNavigationMenu() {
        ((MainActivity) mContext).getNavViewBottom().setVisibility(View.GONE);
    }

    private void initRecycleViews() {
        liveAdapter = new LiveAdapter();
        mLayoutManager = new GridLayoutManager(getContext(), 2);
        rvLiveWallpaper.setHasFixedSize(true);
        rvLiveWallpaper.setLayoutManager(mLayoutManager);
        rvLiveWallpaper.setItemAnimator(new DefaultItemAnimator());
        rvLiveWallpaper.setAdapter(liveAdapter);
        setScrollRecyclerView(rvLiveWallpaper);
    }

    @Override
    public void setDataForViews(List<NewData> listLiveWallpaper) {
        liveAdapter.addItemsWallpaper(listLiveWallpaper);
    }
}
