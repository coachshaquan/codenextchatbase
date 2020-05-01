package com.example.codenextchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class MessageAdapter extends ArrayAdapter<Message> {

    // MessageAdapter Constructor
    public MessageAdapter(Context context, ArrayList<Message> messages){
        super(context, 0, messages);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.message_list_item ,parent, false);
        }

        //TODO: Find Views in MessageAdapter layout


        //TODO: Set our MessageAdapter's Views


        //TODO: Use Glide to display an image
            //TODO: Get current Context
            //TODO: Get and format current Message's photo URL
            //TODO: Use Context, URL and ImageView to display photo using Glide



        return listItemView;


    }
}
