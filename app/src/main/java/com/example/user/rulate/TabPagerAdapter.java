package com.example.user.rulate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by user on 2017-11-02.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    //Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        //Returning the current tabs
        switch (position){
            case 0:
                MainTabFragment1 mainTabFragment1 = new MainTabFragment1();
                return mainTabFragment1;
            case 1:
                MainTabFragment2 mainTabFragment2 = new MainTabFragment2();
                return mainTabFragment2;
            case 2:
                MainTabFragment3 mainTabFragment3 = new MainTabFragment3();
                return mainTabFragment3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
