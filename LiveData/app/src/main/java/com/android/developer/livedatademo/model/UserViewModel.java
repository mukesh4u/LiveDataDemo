package com.android.developer.livedatademo.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by mukesh on 13/6/18.
 * Affle India Pvt Ltd.
 * mukesh.yadav@affle.com
 */
public class UserViewModel extends ViewModel {

    // Create a LiveData with a String
    private MutableLiveData<User> mUser;

    public MutableLiveData<User> getUser() {
        if (mUser == null) {
            mUser = new MutableLiveData<User>();
        }
        return mUser;
    }
}