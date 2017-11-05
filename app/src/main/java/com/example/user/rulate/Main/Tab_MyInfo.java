package com.example.user.rulate.Main;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.rulate.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GoogleAuthProvider;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by user on 2017-11-02.
 */

public class Tab_MyInfo extends Fragment implements View.OnClickListener{
    private FirebaseUser currentUser;
    private ImageView userProfileImage; // 사용자 프로필 사진
    private TextView userID, userName, userLate; //사용자 이메일, 이름, 지각률
    private Button logout; // 로그아웃 버튼
    private String token; // 회원 탈퇴를 위한 유저의 토큰을 받아 올 string
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_myinfo, container, false);

        logout = (Button)view.findViewById(R.id.button_logout);
        logout.setOnClickListener(this);


        initUserProfile(view);

        setHasOptionsMenu(true); //onCreateOptionMenu에서 바뀔 menu 를 승인


        return view;
    }
    private void initUserProfile(View view){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser(); // 현재 로그인 중인 유저의 정보를 가져옴
        userProfileImage = (ImageView)view.findViewById(R.id.user_ProfileImage);
        userID = (TextView)view.findViewById(R.id.user_ID);
        userName = (TextView)view.findViewById(R.id.user_NAME);
        userLate = (TextView)view.findViewById(R.id.user_LATE);

        userID.setText(currentUser.getEmail());
        userName.setText(currentUser.getDisplayName());

        try {
            URL url = new URL(currentUser.getPhotoUrl().toString()); // 구글 사용자 프로필 사진을 URL 형식으로 가져와서 string으로 변형시켜줌
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            Bitmap bitmap = BitmapFactory.decodeStream(bufferedInputStream);
            bufferedInputStream.close();
            userProfileImage.setImageBitmap(bitmap); // URL 형식으로 가져온 이미지를 Bitmap 형식으로 바꾼 뒤, imageview에다가 넣어준다.
        }
        catch(Exception e){

        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) { // res/menu 에서 친구 탭에서 작동 할 menu를 가져온다.
        inflater.inflate(R.menu.mysetting_tab_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_logout: //탈퇴 버튼
                FirebaseAuth.getInstance().signOut(); //로그아웃
                //아래의 앱 탈퇴 기능(delete)이 잘 안됨

//                currentUser = FirebaseAuth.getInstance().getCurrentUser();
//                currentUser.getToken(false).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<GetTokenResult> task) {
//                        if(task.isSuccessful())
//                            token = task.getResult().getToken();
//                    }
//                });
//
//                AuthCredential credential = GoogleAuthProvider.getCredential(currentUser.getUid(),token); //String idToken, String accessToken 이다.
//                currentUser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//
//                        currentUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) { //계정 삭제 완료 시
//                                Toast.makeText(getContext(), "계정이 삭제되었습니다.", Toast.LENGTH_SHORT);
//                                ActivityCompat.finishAffinity(getActivity());
//                            }
//                        });
//                    }
//                });
        }

    }
}
