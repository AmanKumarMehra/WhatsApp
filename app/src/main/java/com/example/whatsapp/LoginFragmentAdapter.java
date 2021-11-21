package com.example.whatsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginFragmentAdapter extends FragmentPagerAdapter {


    public LoginFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){

            case 0: return new LoginFragment();
            case 1: return new SignupFragment();


            default : return new LoginFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;

        if(position == 0){
            title = "Login";
        }else if(position == 1){
            title = "SignUp";
        }

        return title;
    }
}
