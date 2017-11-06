package com.example.user.rulate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by user on 2017-11-02.
 */

public class MainTabFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment2, container, false);

        setHasOptionsMenu(true); //onCreateOptionMenu에서 바뀔 menu 를 승인

        ListView listView;
        GroupListViewAdapter groupListViewAdapter;

        //Adapter 생성
        groupListViewAdapter = new GroupListViewAdapter();

        //리스트뷰 참조 및 Adapter 달기
        listView = (ListView)view.findViewById(R.id.group_listview);
        listView.setAdapter(groupListViewAdapter);

        ///////////////////////////////////////////리스트 아이템 추가 (나중에 서버/DB와 연동 될 것)
        groupListViewAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.ic_account_circle_black_36dp), "지랄발광","6층 피시실");
        groupListViewAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.ic_account_circle_black_36dp), "화산폭발", "5층 피시실");
        groupListViewAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.ic_account_circle_black_36dp), "모앱개발", "천국");
        ///////////////////////////////////////////


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) { // res/menu 에서 친구 탭에서 작동 할 menu를 가져온다.
        inflater.inflate(R.menu.meeting_tab_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
