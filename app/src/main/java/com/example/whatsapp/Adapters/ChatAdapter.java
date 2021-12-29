package com.example.whatsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.Models.MessageModel;
import com.example.whatsapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter{

    ArrayList<MessageModel> messageModels;
    Context context;

    int SENDER_VIEW_TYPE = 1;
    int SENDER_IMAGE_VIEW_TYPE = 3;
    int RECEIVER_VIEW_TYPE = 2;
    int RECEIVER_IMAGE_VIEW_TYPE = 4;

    public ChatAdapter(ArrayList<MessageModel> messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == SENDER_VIEW_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.sample_sender, parent, false);
            return new SenderViewHolder(view);
        }
        if(viewType == SENDER_IMAGE_VIEW_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.smaple_sender_image, parent, false);
            return new SenderViewHolder(view);
        }
        if(viewType == RECEIVER_VIEW_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.sample_receiver, parent, false);
            return new ReceiverViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_receiver_image, parent, false);
            return new ReceiverViewHolder(view);
        }

    }

    @Override
    public int getItemViewType(int position) {
        MessageModel messageModel = messageModels.get(position);
        String str = messageModel.getMessage();
        str = str.substring(0, 5);

        if(messageModels.get(position).getuId().equals(FirebaseAuth.getInstance().getUid())) {
            if(str.equals("https")){
                return SENDER_IMAGE_VIEW_TYPE;
            }
            else
                return SENDER_VIEW_TYPE;
        }
        else{
            if(str.equals("https")){
                return RECEIVER_IMAGE_VIEW_TYPE;
            }
            else
                return RECEIVER_VIEW_TYPE;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModel messageModel = messageModels.get(position);
        String type = messageModel.getType();


        if(holder.getClass() == SenderViewHolder.class){
            if(type.equals("image")){
                Uri uri = Uri.parse(messageModel.getMessage());
                Picasso.get().load(uri).into(((SenderViewHolder) holder).senderImage);
            }
            else if(type.equals("text")){
                ((SenderViewHolder)holder).senderMsg.setText(messageModel.getMessage());
            }
            else{
                String url = messageModel.getMessage();
                ((SenderViewHolder) holder).senderImage.setBackgroundResource(R.drawable.docs);

                ((SenderViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(messageModel.getMessage()));
                        ((SenderViewHolder) holder).itemView.getContext().startActivity(intent);
                    }
                });
            }


        }
        else{
            if(type.equals("https")){
                Uri uri = Uri.parse(messageModel.getMessage());
                Picasso.get().load(uri).into(((ReceiverViewHolder) holder).receiverImage);
            }
            else if(type.equals("text")){
                ((ReceiverViewHolder)holder).receiverMsg.setText(messageModel.getMessage());
            }
            else{
                String url = messageModel.getMessage();
                ((ReceiverViewHolder) holder).receiverImage.setBackgroundResource(R.drawable.docs);

                ((ReceiverViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(messageModel.getMessage()));
                        ((ReceiverViewHolder) holder).itemView.getContext().startActivity(intent);
                    }
                });
            }


        }
    }


    ///////////////////////////////
    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public class ReceiverViewHolder extends RecyclerView.ViewHolder{

        TextView receiverMsg, receiverTime;
        ImageView receiverImage;
        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);

            receiverMsg = itemView.findViewById(R.id.receiverText);
            receiverTime = itemView.findViewById(R.id.receiverTime);
            receiverImage = itemView.findViewById(R.id.receiverImage);

        }
    }

    public class SenderViewHolder extends RecyclerView.ViewHolder{

        TextView senderMsg, senderTime;
        ImageView senderImage;
        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);

            senderMsg = itemView.findViewById(R.id.senderText);
            senderTime = itemView.findViewById(R.id.senderTime);
            senderImage = itemView.findViewById(R.id.senderImage);
        }
    }
}
