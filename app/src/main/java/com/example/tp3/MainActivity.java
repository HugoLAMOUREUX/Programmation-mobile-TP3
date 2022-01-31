package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements InterfaceLesTaches{

    private LesTachesFragment fragmentLesTaches;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm=this.getSupportFragmentManager();
        fragmentLesTaches =(LesTachesFragment) fm.findFragmentById(R.id.idFragmentList);
    }



    public void tacheSelectionne(Tache t){
        Intent intent = new Intent(this, DetailTacheActivity.class);

        intent.putExtra(Constantes.TACHE, t.getNom());
        intent.putExtra(Constantes.DUREE, t.getDuree());
        intent.putExtra(Constantes.DESCRIPTION, t.getDescription());
        intent.putExtra(Constantes.CATEGORIE, t.getCategorie().toString());
        this.startActivity(intent);
    }
    /*public void ajoutOnClick(View view){
        fragmentLesTaches.ajoutTache(new Tache("App Mobile","Travail","120","tp3"));

    }*/


}