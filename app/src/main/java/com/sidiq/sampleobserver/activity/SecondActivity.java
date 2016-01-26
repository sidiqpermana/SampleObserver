package com.sidiq.sampleobserver.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sidiq.sampleobserver.observable.ObservableItem;
import com.sidiq.sampleobserver.model.PostItem;
import com.sidiq.sampleobserver.R;
import com.sidiq.sampleobserver.application.SampleObserverApplication;
import com.sidiq.sampleobserver.model.User;

import java.util.Observable;
import java.util.Observer;

public class SecondActivity extends AppCompatActivity implements Observer, View.OnClickListener{
    private TextView txtUsername, txtPostTitle;
    private Button btnGoToThirdActivity;

    private SampleObserverApplication mSampleObserverApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtUsername = (TextView)findViewById(R.id.txt_username);
        txtPostTitle = (TextView)findViewById(R.id.txt_post_title);
        btnGoToThirdActivity = (Button)findViewById(R.id.btn_go_to_third_activity);
        btnGoToThirdActivity.setOnClickListener(this);

        //Register observer
        mSampleObserverApplication = (SampleObserverApplication)getApplication();
        mSampleObserverApplication.getChangesObservable().addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        ObservableItem observableItem = (ObservableItem)data;
        User mUser = observableItem.getUser();
        PostItem mPostItem = observableItem.getPostItem();

        if (mUser != null){
            txtUsername.setText("Username : "+mUser.getName());
        }

        if (mPostItem != null){
            txtPostTitle.setText("Post : "+mPostItem.getName()+" with total view "+mPostItem.getTotalView());
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_go_to_third_activity){
            Intent mIntent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(mIntent);
        }
    }


    @Override
    protected void onDestroy() {
        mSampleObserverApplication.getChangesObservable().deleteObserver(this);
        super.onDestroy();
    }
}
