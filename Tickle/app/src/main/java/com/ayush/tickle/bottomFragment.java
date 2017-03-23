package com.ayush.tickle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.BaseBundle;
import android.support.v4.app.Fragment;

public class bottomFragment extends Fragment{

    private static TextView topmeme;
    private  static TextView bottommeme;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.bottom_sec_fragment,container,false);
        topmeme =(TextView)view.findViewById(R.id.top);
        bottommeme=(TextView)view.findViewById(R.id.bottom);
        return view;
    }
    public void setMemeText(String top, String bottom){
        topmeme.setText(top);
        bottommeme.setText(bottom);
    }
}
