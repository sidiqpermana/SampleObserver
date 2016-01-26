package com.sidiq.sampleobserver.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sidiq.sampleobserver.model.PostItem;
import com.sidiq.sampleobserver.R;
import com.sidiq.sampleobserver.application.SampleObserverApplication;
import com.sidiq.sampleobserver.model.User;

import java.util.Observable;
import java.util.Observer;

public class ThirdActivity extends AppCompatActivity implements Observer, View.OnClickListener{

    private Button btnUpdateUsername, btnUpdatePost;
    private SampleObserverApplication mSampleObserverApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnUpdatePost = (Button)findViewById(R.id.btn_update_post);
        btnUpdateUsername = (Button)findViewById(R.id.btn_update_username);

        btnUpdatePost.setOnClickListener(this);
        btnUpdateUsername.setOnClickListener(this);

        mSampleObserverApplication = (SampleObserverApplication)getApplication();
        mSampleObserverApplication.getChangesObservable().addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_update_post){
            PostItem mPostItem = new PostItem();
            mPostItem.setName("Android Juara");
            mPostItem.setTotalView(350);

            mSampleObserverApplication.getChangesObservable().notifyPostItemChanges(mPostItem);
        }

        if (v.getId() == R.id.btn_update_username){
            User mUser = new User();
            mUser.setName("Sidiq Permana");

            mSampleObserverApplication.getChangesObservable().notifyUserChanges(mUser);
        }
    }

    @Override
    protected void onDestroy() {
        //Unregister observer
        mSampleObserverApplication.getChangesObservable().deleteObserver(this);
        super.onDestroy();
    }
}
