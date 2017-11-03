package com.example.user.rulate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 2017-11-02.
 */

public class MainTabFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment2, container, false);

        setHasOptionsMenu(true); //onCreateOptionMenu에서 바뀔 menu 를 승인


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) { // res/menu 에서 친구 탭에서 작동 할 menu를 가져온다.
        inflater.inflate(R.menu.meeting_tab_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
