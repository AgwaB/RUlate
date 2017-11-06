package com.example.user.rulate;

import android.graphics.drawable.Drawable;

/**
 * Created by user on 2017-11-04.
 */

public class GroupListItem {
    private Drawable groupIcon; // 그룹의 프로필 사진
    private String groupName; // 그룹의 이름
    private String groupLocatioin; // 그룹의 장소


    public void setGroupIcon(Drawable icon){
        groupIcon = icon;
    }
    public void setGroupName(String name){
        groupName = name;
    }
    public void setGroupLocation(String location){
        groupLocatioin = location;
    }

    // Date , Time 아직 안받았음 String으로 받아야할지 Date 로 받아야할지 고민

    public Drawable getGroupIcon(){
        return this.groupIcon;
    }
    public String getGroupName(){
        return this.groupName;
    }
    public String getGroupLocation(){
        return this.groupLocatioin;
    }


}
