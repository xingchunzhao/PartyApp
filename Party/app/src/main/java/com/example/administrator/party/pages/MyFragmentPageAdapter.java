package com.example.administrator.party.pages;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/6/13.
 */

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    //Fragment Object
    private HomeFragment fg1 = null;
    private FriendsFragment fg2 = null;
    private CodeFragment fg3 = null;
    private MyFragment fg4 = null;

    public MyFragmentPageAdapter(FragmentManager fm) {
        super(fm);
        fg1 = new HomeFragment();
        fg2 = new FriendsFragment();
        fg3 = new CodeFragment();
        fg4 = new MyFragment();
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case Navigation.PAGE_ONE:
                fragment = fg1;
                break;
            case Navigation.PAGE_TWO:
                fragment = fg2;
                break;
            case Navigation.PAGE_THREE:
                fragment = fg3;
                break;
            case Navigation.PAGE_FOUR:
                fragment = fg4;
                break;
        }
        return fragment;
    }

}
