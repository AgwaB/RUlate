package com.example.user.rulate.Main.Tab_Friend;

import android.graphics.drawable.Drawable;

/**
 * Created by user on 2017-11-04.
 */

public class FriendListItem {
    private Drawable userIcon; // 유저의 프로필 사진
    private String userName; // 유저의 이름
    private String userLateRatio; // 유저의 지각율
    private String userLateAvgMin; // 유저의 평균 지각 시간

    public void setUserIcon(Drawable icon){
        userIcon = icon;
    }
    public void setUserName(String name){
        userName = name;
    }
    public void setUserLateRatio(String ratio){
        userLateRatio = ratio;
    }
    public void setUserLateAvgMin(String avgMin){
        userLateAvgMin = avgMin;
    }

    public Drawable getUserIcon(){
        return this.userIcon;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getUserLateRatio(){
        return this.userLateRatio;
    }
    public String getUserLateAvgMin(){
        return this.userLateAvgMin;
    }

 }
