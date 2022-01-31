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
    /*private TextView tacheTv;
    private TextView dureeTv;
    private ImageView catIv;
    private TextView descriptionTv;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tache);

        fm=this.getSupportFragmentManager();
        fragmentDetail =(DetailFragment) fm.findFragmentById(R.id.idDetail);

        /*tacheTv=findViewById(R.id.tacheId);
        dureeTv=findViewById(R.id.dureeId);
        catIv=findViewById(R.id.imgId);
        descriptionTv=findViewById(R.id.descriptionId);*/

        Intent intent=this.getIntent();
        tache=intent.getStringExtra(Constantes.TACHE);
        duree=intent.getIntExtra(Constantes.DUREE,0)+"min";
        cat=intent.getStringExtra(Constantes.CATEGORIE);
        description=intent.getStringExtra(Constantes.DESCRIPTION);

        fragmentDetail.set(tache,duree,cat,description);
        //setData(tache,duree,cat,description);
    }

   /* public void setData(String t,String d,String c,String descr){
        tacheTv.setText(t);
        dureeTv.setText(d);
        descriptionTv.setText(descr);
        switch (c){
            case "Sport": {
                catIv.setImageResource(R.drawable.sport);
                break;
            }
            case "Enfants": {
                catIv.setImageResource(R.drawable.enfant);
                break;
            }
            case "Courses": {
                catIv.setImageResource(R.drawable.courses);
                break;
            }
            case "Menage": {
                catIv.setImageResource(R.drawable.menage);
                break;
            }
            case "Lecture": {
                catIv.setImageResource(R.drawable.lecture);
                break;
            }
            case "Travail": {
                catIv.setImageResource(R.drawable.travail);
                break;
            }
            case "Autre": {
                catIv.setImageResource(R.drawable.point_interro_);
                break;
            }
        }

    }*/


}