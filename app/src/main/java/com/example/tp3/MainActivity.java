package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements InterfaceLesTaches{

    private LesTachesFragment fragmentLesTaches;
    private DetailFragment fragmentDetail;
    private FragmentManager fm;

    private TextView tache;
    private TextView duree;
    private ImageView cat;
    private TextView description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm=this.getSupportFragmentManager();
        fragmentLesTaches =(LesTachesFragment) fm.findFragmentById(R.id.idFragmentList);
        fragmentDetail= (DetailFragment) fm.findFragmentById(R.id.idDetail);


        tache=findViewById(R.id.tacheId);
        duree=findViewById(R.id.dureeId);
        cat=findViewById(R.id.imgId);
        description=findViewById(R.id.descriptionId);
    }

    /* Lancement de AjoutActivity (via le fragment) */
    public void ajouterBtn(View view){
        fragmentLesTaches.ajouterBtn2();
    }


    /* En paysage, affiche les informations de la tâches sur la partie droite de l'écran, en portrait lance l'activité DetailTacheActivity */
    public void tacheSelectionne(Tache t){
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            set(t.getNom(),t.getDuree()+" min",t.getCategorie()+"",t.getDescription());
        } else {
            Intent intent = new Intent(this, DetailTacheActivity.class);

            intent.putExtra(Constantes.TACHE, t.getNom());
            intent.putExtra(Constantes.DUREE, t.getDuree());
            intent.putExtra(Constantes.DESCRIPTION, t.getDescription());
            intent.putExtra(Constantes.CATEGORIE, t.getCategorie().toString());
            this.startActivity(intent);
        }

    }

    /* Méthode qui set les données aux TextView et ImageView du fragment DetailFragment */
    public void set(String t,String d,String c,String descr){
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

}


