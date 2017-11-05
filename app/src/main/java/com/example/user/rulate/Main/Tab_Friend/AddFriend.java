package com.example.user.rulate.Main.Tab_Friend;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        userName = (TextView)findViewById(R.id.text_userName);
        clearEditText = (ClearEditText)findViewById(R.id.search_friend);
        button_search = (Button)findViewById(R.id.button_search);


        clearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                button_search.setTextColor(Color.parseColor("#bebdbd")); // 버튼 text 색깔 회색으로 하고
                button_search.setEnabled(false); // 버튼 비활성화
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(clearEditText.getText().toString().equals("")){ // edittext에 아무것도 입력이 안되면
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
                ValueEventListener infoListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){ // 데이터 search 잘 안됨 object가 제대로 안들어옴...
                            UserInfo userInfo = singleSnapshot.child("users").child(clearEditText.getText().toString()).getValue(UserInfo.class);
                            userName.setText(userInfo.getName());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                };
                mDatabase.addValueEventListener(infoListener);
            }
        });

    }
}
