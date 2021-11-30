package com.example.whatsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SignupFragment extends Fragment {

    /*public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }*/

    EditText email, phone, pass, confirm_pass;
    Button signUp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_signup, container, false);

        email = v.findViewById(R.id.email);
        phone = v.findViewById(R.id.mobile);
        pass = v.findViewById(R.id.pass);
        confirm_pass = v.findViewById(R.id.confirm_pass);
        signUp = v.findViewById(R.id.signup);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity().getBaseContext(), OTP.class);
                i.putExtra("mobile", "+91" + phone.getText().toString());
                getActivity().startActivity(i);
            }
        });

        return v;
    }
}