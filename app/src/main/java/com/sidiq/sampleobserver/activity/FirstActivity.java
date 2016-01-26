package com.sidiq.sampleobserver.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sidiq.sampleobserver.observable.ObservableItem;
import com.sidiq.sampleobserver.R;
import com.sidiq.sampleobserver.application.SampleObserverApplication;
import com.sidiq.sampleobserver.model.User;

import java.util.Observable;
import java.util.Observer;

public class FirstActivity extends AppCompatActivity implements Observer, View.OnClickListener{
    private TextView txtUsername;
    private Button btnGoToSecondActivity;

    private SampleObserverApplication mSampleObserverApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = (TextView)findViewById(R.id.txt_username);
        btnGoToSecondActivity = (Button)findViewById(R.id.btn_go_to_second_activity);
        btnGoToSecondActivity.setOnClickListener(this);

        //Register observer
        mSampleObserverApplication = (SampleObserverApplication)getApplication();
        mSampleObserverApplication.getChangesObservable().addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        ObservableItem observableItem = (ObservableItem)data;
        User mUser = observableItem.getUser();

        if (mUser != null){
            txtUsername.setText("Username : "+mUser.getName());
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_go_to_second_activity){
            Intent mIntent = new Intent(FirstActivity.this, SecondActivity.class);
            startActivity(mIntent);
        }
    }

    @Override
    protected void onDestroy() {
        //Unregister observer
        mSampleObserverApplication.getChangesObservable().deleteObserver(this);
        super.onDestroy();
    }
}
