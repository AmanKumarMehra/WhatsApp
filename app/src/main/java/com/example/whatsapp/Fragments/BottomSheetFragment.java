package com.example.whatsapp.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.whatsapp.R;
import com.example.whatsapp.SendImage;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BottomSheetFragment extends BottomSheetDialogFragment {


    LinearLayout document, camera, gallery;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_bottom_sheet, container, false);


        document = v.findViewById(R.id.document);
        camera = v.findViewById(R.id.camera);
        gallery = v.findViewById(R.id.gallery);


        document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doc = new Intent();
                doc.setType("application/*");
                doc.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(doc);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camera_intent);
            }
        });

        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        Intent intent = new Intent(getActivity().getBaseContext(), SendImage.class);
                        intent.putExtra("Url", uri.toString());
                        getActivity().startActivity(intent);
                    }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");


            }
        });

        return v;
    }
}