package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailTacheActivity extends AppCompatActivity {

    private DetailFragment fragmentDetail;
    private FragmentManager fm;

    private String tache;
    private String duree;
    private String cat;
    private String description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tache);

        fm=this.getSupportFragmentManager();
        fragmentDetail =(DetailFragment) fm.findFragmentById(R.id.idDetail);

        Intent intent=this.getIntent();
        tache=intent.getStringExtra(Constantes.TACHE);
        duree=intent.getIntExtra(Constantes.DUREE,0)+"min";
        cat=intent.getStringExtra(Constantes.CATEGORIE);
        description=intent.getStringExtra(Constantes.DESCRIPTION);

        fragmentDetail.set(tache,duree,cat,description);
    }


}