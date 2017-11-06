package com.example.user.rulate;

import android.app.Activity;
import android.content.Intent;
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

public class MainTabFragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);

        setHasOptionsMenu(true); //onCreateOptionMenu에서 바뀔 menu 를 승인

        ListView listView;
        FriendListViewAdapter friendListViewAdapter;

        //Adapter 생성
        friendListViewAdapter = new FriendListViewAdapter();

        //리스트뷰 참조 및 Adapter 달기
        listView = (ListView)view.findViewById(R.id.friend_listview);
        listView.setAdapter(friendListViewAdapter);

        ///////////////////////////////////////////리스트 아이템 추가 (나중에 서버/DB와 연동 될 것)
        friendListViewAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.ic_account_circle_black_36dp), "김성재", "35","15");
        friendListViewAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.ic_account_circle_black_36dp), "김성민", "20","5");
        friendListViewAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.ic_account_circle_black_36dp), "유진수", "15","10");
        ///////////////////////////////////////////


        return view;
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) { // FriendNotification class에서 친구를 수락 했을 시, 서버, DB와 알맞게 통신할 것임.
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){

            if(resultCode == Activity.RESULT_OK){
                //반환값이 있을 경우
            }
            if(resultCode == Activity.RESULT_CANCELED){
                //만약 반환값이 없을 경우
            }
        }

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) { // res/menu 에서 친구 탭에서 작동 할 menu를 가져온다.
        inflater.inflate(R.menu.friend_tab_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
