package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements InterfaceLesTaches{

    private LesTachesFragment fragmentLesTaches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm=this.getSupportFragmentManager();
        fragmentLesTaches =(LesTachesFragment) fm.findFragmentById(R.id.idFragmentList);
    }



    public void tacheSelectionne(Tache t){

    }
    /*public void ajoutOnClick(View view){
        fragmentLesTaches.ajoutTache(new Tache("App Mobile","Travail","120","tp3"));

    }*/


}