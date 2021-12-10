package com.example.whatsapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.whatsapp.MainActivity;
import com.example.whatsapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment implements OnClickListener {

    EditText email, pass;
    Button login;
    FirebaseAuth mAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        email = v.findViewById(R.id.email);
        pass = v.findViewById(R.id.pass);

        login = v.findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {

        String e_mail = email.getText().toString();
        String password = pass.getText().toString();

        mAuth.signInWithEmailAndPassword(e_mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    /*email.setText("");
                    pass.setText("");
                    Toast.makeText(getActivity(), "Successfully LogedIn", Toast.LENGTH_SHORT).show();*/

                    startActivity(new Intent(getActivity(), MainActivity.class));
                }
                else {
                    Toast.makeText(getActivity(), "Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}