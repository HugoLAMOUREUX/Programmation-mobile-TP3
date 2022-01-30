package com.example.tp3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    private InterfaceLesTaches interfaceTaches;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=inflater.inflate(R.layout.detailactivityfragment,container,false);

        return v;


    }

    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof InterfaceLesTaches)
            interfaceTaches=(InterfaceLesTaches) context;
    }
}


