package com.androidvn.wallpaper.ui.trending;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.ui.base.BaseFragment;
import com.androidvn.wallpaper.ui.main.MainActivity;
import com.androidvn.wallpaper.ui.trending.adapter.TrendingPagerAdapter;
import com.androidvn.wallpaper.ui.trending.live.LiveFragment;
import com.androidvn.wallpaper.ui.trending.news.NewFragment;
import com.androidvn.wallpaper.ui.trending.popular.PopularFragment;

import butterknife.BindView;

public class TrendingFragment extends BaseFragment {
    TrendingPagerAdapter trendingPagerAdapter;
    @BindView(R.id.vp_trending)
    ViewPager vpTrending;
    @BindView(R.id.tab_trending)
    TabLayout tabTrending;

    public static TrendingFragment newInstances(){
        TrendingFragment fragment = new TrendingFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_trending;
    }

    @Override
    public void onCreateView() {
        setupViewPager();
        Log.d("test", "onCreateViewTrending: ");
    }

    @Override
    public void setActionForViews() {

    }

    @Override
    public void showBottomNavigationMenu() {
    }

    @Override
    public void hideBottomNavigationMenu() {
    }

    private void setupViewPager(){
        trendingPagerAdapter = new TrendingPagerAdapter(getChildFragmentManager());
        trendingPagerAdapter.addFragment(NewFragment.newInstance(), "New");
        trendingPagerAdapter.addFragment(PopularFragment.newInstance(), "Popular");
        trendingPagerAdapter.addFragment(LiveFragment.newInstances(), "Live");
        vpTrending.setAdapter(trendingPagerAdapter);
        tabTrending.setupWithViewPager(vpTrending);
        trendingPagerAdapter.notifyDataSetChanged();
    }
}
