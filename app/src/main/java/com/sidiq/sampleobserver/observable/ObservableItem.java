package com.sidiq.sampleobserver.observable;

import com.sidiq.sampleobserver.model.PostItem;
import com.sidiq.sampleobserver.model.User;

/**
 * Created by Sidiq on 26/01/2016.
 */
public class ObservableItem {
    private User user;
    private PostItem postItem;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostItem getPostItem() {
        return postItem;
    }

    public void setPostItem(PostItem postItem) {
        this.postItem = postItem;
    }
}
