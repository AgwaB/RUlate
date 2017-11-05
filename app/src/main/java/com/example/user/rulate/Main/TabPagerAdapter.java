package com.example.user.rulate.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.rulate.Main.Tab_Friend.Tab_Friend;
import com.example.user.rulate.Main.Tab_Meeting.Tab_Meeting;

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
                Tab_Friend tabFriend = new Tab_Friend();
                return tabFriend;
            case 1:
                Tab_Meeting tabMeeting = new Tab_Meeting();
                return tabMeeting;
            case 2:
                Tab_MyInfo tabMyInfo = new Tab_MyInfo();
                return tabMyInfo;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
