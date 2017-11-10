package com.example.user.rulate.Main.Tab_Friend;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.rulate.Main.ClearEditText;
import com.example.user.rulate.Main.UserInfo;
import com.example.user.rulate.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by user on 2017-11-05.
 */

public class AddFriend extends Activity {
    private TextView userName;
    private ClearEditText clearEditText;
    private Button button_search;
    private DatabaseReference mDatabase;
    private LinearLayout view_friend_layout;
    private TextView view_no_friend_textview;
    boolean isExist = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);


        mDatabase = FirebaseDatabase.getInstance().getReference("users");

        userName = (TextView)findViewById(R.id.text_userName);
        clearEditText = (ClearEditText)findViewById(R.id.search_friend);
        button_search = (Button)findViewById(R.id.button_search);
        view_friend_layout = (LinearLayout)findViewById(R.id.view_invited_friend);
        view_no_friend_textview = (TextView)findViewById(R.id.view_no_invited_friend);


        clearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                button_search.setTextColor(Color.parseColor("#bebdbd")); // 버튼 text 색깔 회색으로 하고
                button_search.setEnabled(false); // 버튼 비활성화
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(clearEditText.getText().toString().equals("")){ // edittext에 아무것도 입력이 안되면
                    view_friend_layout.setVisibility(View.GONE); // 검색 결과 창 사라짐
                    view_no_friend_textview.setVisibility(View.GONE); // 검색 결과 창 사라짐
                    button_search.setTextColor(Color.parseColor("#bebdbd")); // 버튼 text 색깔 회색으로 하고
                    button_search.setEnabled(false); // 버튼 비활성화
                }
                else{                             // edittext에 입력이 있으면
                    button_search.setTextColor(Color.BLACK); // 버튼 text 검은색으로 하고
                    button_search.setEnabled(true); // 버튼 활성화
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        button_search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){ // 데이터 search 잘 안됨 object가 제대로 안들어옴...
                                if(singleSnapshot.getKey().equals(clearEditText.getText().toString())){
                                    UserInfo userInfo = singleSnapshot.getValue(UserInfo.class); // id에 맞는 데이터를 미리 선언해 둔 UserInfo 형태로 가져옴
                                    userName.setText(userInfo.getName());
                                    isExist = true;
                                }
                            }
                            if(isExist == true) { // ID가 존재하면 해당 아이디를 보여주고
                                view_friend_layout.setVisibility(View.VISIBLE);
                                isExist = false; // 다시 false로 초기화 한다.
                            }
                            else
                                view_no_friend_textview.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }
            });


        }
}
