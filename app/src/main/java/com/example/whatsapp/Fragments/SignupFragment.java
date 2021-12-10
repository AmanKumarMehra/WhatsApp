package com.example.whatsapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.whatsapp.OTP;
import com.example.whatsapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class SignupFragment extends Fragment {


    EditText username, email, phone, pass, confirm_pass;
    Button signUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_signup, container, false);

        username = v.findViewById(R.id.username);
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
                i.putExtra("user", username.getText().toString());
                i.putExtra("email", email.getText().toString());
                i.putExtra("password", pass.getText().toString());

                getActivity().startActivity(i);


            }
        });

        return v;
    }
}