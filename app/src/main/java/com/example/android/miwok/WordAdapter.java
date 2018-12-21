package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> list, int color){

        super(context,0,list);
        mColorResourceId = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Word currentWord = getItem(position);
        View listIteamView = convertView;

        if(listIteamView == null){
            listIteamView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView miwokTextView = (TextView)listIteamView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getmMiwokTranslation());

        TextView defaultTextView = (TextView)listIteamView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        ImageView mImageView = (ImageView)listIteamView.findViewById(R.id.image_view);
        if(currentWord.hasImage()){
            mImageView.setImageResource(currentWord.getmImageResourceId());

        }
        else {
            mImageView.setVisibility(View.GONE);
        }

        View textContainer = listIteamView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(),mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listIteamView;
    }
}
