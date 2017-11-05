package com.example.user.rulate.Main;

/**
 * Created by user on 2017-11-05.
 */

public class UserInfo {
    public String profileURL;
    public String email;
    public String name;
    public String userUID;

    public UserInfo(){

    }

    public UserInfo(String profileURL, String email, String name, String userUID){
        this.profileURL = profileURL;
        this.email = email;
        this.name = name;
        this.userUID = userUID;
    }

    public void setProfileURL(String profileURL){
        this.profileURL = profileURL;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setUserUID(String userUID){
        this.userUID = userUID;
    }

    public String getProfileURL(){
        return profileURL;
    }
    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public String getUserUID(){
        return userUID;
    }
}
