package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class WordAdaptor extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdaptor(Context context, ArrayList<Word> words, int colorId){
        super(context,0,words);
        mColorResourceId=colorId;
    }

    //Position i.e. the starting point
    //convertView is the recucled view that needs to be populated
    //The list item will be added to the parent view group as list item

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word currentWord= getItem(position);

        View listItemView=convertView;
        if (listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView miWokView=(TextView)listItemView.findViewById(R.id.miwok_text_view);
        miWokView.setText(currentWord.getmiwokTranslation());

        TextView defaultView = (TextView)listItemView.findViewById(R.id.default_text_view);
        defaultView.setText(currentWord.getdefaultTranslation());

        ImageView imageView = (ImageView)listItemView.findViewById((R.id.image));

        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageResourceId());
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View listView=(View)listItemView.findViewById(R.id.linear);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        listView.setBackgroundColor(color);


        return listItemView;
    }
}
