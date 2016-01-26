package com.sidiq.sampleobserver.observable;

import com.sidiq.sampleobserver.model.PostItem;
import com.sidiq.sampleobserver.model.User;

import java.util.Observable;

/**
 * Created by Sidiq on 26/01/2016.
 */
public class ChangesObservable extends Observable {
    public void notifyUserChanges(User mUser){
        ObservableItem mObservableItem = new ObservableItem();
        mObservableItem.setUser(mUser);

        setChanged();

        notifyObservers(mObservableItem);
    }

    public void notifyPostItemChanges(PostItem mPostItem){
        ObservableItem mObservableItem = new ObservableItem();
        mObservableItem.setPostItem(mPostItem);

        setChanged();

        notifyObservers(mObservableItem);
    }
}
