package com.example.user.rulate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by user on 2017-11-03.
 */

public class FriendNotification extends Activity {
    private Toolbar toolbar;
    private ImageButton back_to_friend_tab;
    Intent intent = new Intent();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_notification);


        back_to_friend_tab = (ImageButton)findViewById(R.id.logo_left_button);

        back_to_friend_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
