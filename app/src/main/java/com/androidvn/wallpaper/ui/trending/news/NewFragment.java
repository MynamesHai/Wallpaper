package com.androidvn.wallpaper.ui.trending.news;

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
import com.androidvn.wallpaper.ui.trending.news.adapter.NewAdapter;

import java.util.List;

import butterknife.BindView;

public class NewFragment extends BaseFragment implements NewMvp {

    @BindView(R.id.rv_news_wallpaper)
    RecyclerView rvNewsWallpaper;
    @BindView(R.id.swipe_layout_new)
    SwipeRefreshLayout swipeLayoutNew;

    private NewAdapter newAdapter;
    private LinearLayoutManager mLayoutManager;
    private NewsPresenter mPresenter;
    private Context mContext;


    public static NewFragment newInstance() {
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
        mContext = getContext();
        mPresenter = new NewsPresenter(mContext);
        mPresenter.attachView(this);
        initRecycleViews();
        mPresenter.doInGetNewsWallpaper();
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
        newAdapter = new NewAdapter();
        mLayoutManager = new GridLayoutManager(getContext(), 2);
        rvNewsWallpaper.setHasFixedSize(true);
        rvNewsWallpaper.setLayoutManager(mLayoutManager);
        rvNewsWallpaper.setItemAnimator(new DefaultItemAnimator());
        rvNewsWallpaper.setAdapter(newAdapter);
        setScrollRecyclerView(rvNewsWallpaper);
    }

    @Override
    public void setDataForViews(List<NewData> listNewWallpaper) {
        newAdapter.addItemsWallpaper(listNewWallpaper);
    }

}
