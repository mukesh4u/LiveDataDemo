package com.android.developer.livedatademo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.developer.livedatademo.databinding.ActivityMainBinding;
import com.android.developer.livedatademo.model.User;
import com.android.developer.livedatademo.model.UserViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    UserViewModel userViewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Get the ViewModel.
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        // Create the observer which updates the UI.
        final Observer<User> nameObserver = new Observer<User>() {
            @Override
            public void onChanged(@Nullable final User user) {
                // Update the UI, in this case, a TextView.
                binding.tvUserName.setText(user.getName());
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        userViewModel.getUser().observe(this, nameObserver);
        binding.btnClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        User user = new User();
        user.setName("Mukesh Yadav");
        user.setAge("25");
        userViewModel.getUser().setValue(user);
    }
}
