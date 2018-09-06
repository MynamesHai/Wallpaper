package com.androidvn.wallpaper.ui.trending.popular;

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
import com.androidvn.wallpaper.ui.trending.popular.adapter.PopularAdapter;

import java.util.List;

import butterknife.BindView;

public class PopularFragment extends BaseFragment implements PopularMvp {
    @BindView(R.id.swipe_layout_popular)
    SwipeRefreshLayout swipeLayoutPopular;
    private PopularPresenter mPresenter;
    private PopularAdapter mAdapter;
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    @BindView(R.id.rv_popular_wallpaper)
    RecyclerView rvPopular;

    public static PopularFragment newInstance() {
        PopularFragment fragment = new PopularFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wallpaper_popular;
    }

    @Override
    public void onCreateView() {
        mContext = getContext();
        mPresenter = new PopularPresenter(mContext);
        mPresenter.attachView(this);
        initRecycleViews();
        mPresenter.doInGetPopularWallpaper();
    }

    @Override
    public void setActionForViews() {

    }

    @Override
    public void showBottomNavigationMenu() {
        ((MainActivity) getContext()).getNavViewBottom().setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBottomNavigationMenu() {
        ((MainActivity) getContext()).getNavViewBottom().setVisibility(View.GONE);
    }

    private void initRecycleViews() {
        mAdapter = new PopularAdapter();
        mLayoutManager = new GridLayoutManager(getContext(), 2);
        rvPopular.setHasFixedSize(true);
        rvPopular.setLayoutManager(mLayoutManager);
        rvPopular.setItemAnimator(new DefaultItemAnimator());
        rvPopular.setAdapter(mAdapter);
        setScrollRecyclerView(rvPopular);
    }

    @Override
    public void setDataForViews(List<NewData> listPopularWallpaper) {
        mAdapter.addItemsWallpaper(listPopularWallpaper);
    }

}
