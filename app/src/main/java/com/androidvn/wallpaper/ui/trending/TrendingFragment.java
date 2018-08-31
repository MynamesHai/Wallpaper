package com.androidvn.wallpaper.ui.trending;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.ui.base.BaseFragment;
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

    private int[] tabIcons = {
            R.drawable.ic_fiber_new_white_24dp,
            R.drawable.ic_star_white_24dp,
            R.drawable.ic_live_tv_white_24dp
    };

    @Override
    public int getLayoutId() {
        return R.layout.fragment_trending;
    }

    @Override
    public void onCreateView() {
        setupViewPager(vpTrending);
        tabTrending.setupWithViewPager(vpTrending);
    }

    @Override
    public void setActionForViews() {

    }

    public void setupViewPager(ViewPager viewPager) {
        trendingPagerAdapter = new TrendingPagerAdapter(mActivity.getSupportFragmentManager());
        trendingPagerAdapter.addFragment(new NewFragment(), "New");
        trendingPagerAdapter.addFragment(new PopularFragment(), "Popular");
        trendingPagerAdapter.addFragment(new LiveFragment(), "Live");
        viewPager.setAdapter(trendingPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
    }

    private void setupTabIcons() {
        tabTrending.getTabAt(0).setIcon(tabIcons[0]);
        tabTrending.getTabAt(1).setIcon(tabIcons[1]);
        tabTrending.getTabAt(2).setIcon(tabIcons[2]);
    }

}
