package com.example.tp3;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    private InterfaceLesTaches interfaceTaches;

    private TextView tache;
    private TextView duree;
    private ImageView cat;
    private TextView description;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=inflater.inflate(R.layout.detailactivityfragment,container,false);
        tache=v.findViewById(R.id.tacheId);
        duree=v.findViewById(R.id.dureeId);
        cat=v.findViewById(R.id.imgId);
        description=v.findViewById(R.id.descriptionId);
        return v;
    }

    public void set(String t,String d,String c,String descr){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
             public void run() {

                tache.setText(t);
                duree.setText(d);
                description.setText(descr);
               switch (c){
                    case "Sport": {
                        cat.setImageResource(R.drawable.sport);
                        break;
                    }
                    case "Enfants": {
                        cat.setImageResource(R.drawable.enfant);
                        break;
                    }
                    case "Courses": {
                        cat.setImageResource(R.drawable.courses);
                        break;
                    }
                    case "Menage": {
                        cat.setImageResource(R.drawable.menage);
                        break;
                    }
                    case "Lecture": {
                        cat.setImageResource(R.drawable.lecture);
                        break;
                    }
                    case "Travail": {
                        cat.setImageResource(R.drawable.travail);
                        break;
                    }
                    case "Autre": {
                        cat.setImageResource(R.drawable.point_interro_);
                        break;
                    }
                }

           }
    }, 1);


    }

}


