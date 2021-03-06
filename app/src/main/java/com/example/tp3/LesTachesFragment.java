package com.example.tp3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LesTachesFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Tache> mesTaches;
    private TacheAdapter tacheAdapter;
    private InterfaceLesTaches interfaceLesTaches;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=inflater.inflate(R.layout.layout_fragment_list_tache,container,false);

        /* Vérification si l'application a déja été ouverte */
        if(savedInstanceState==null) {
            initTaches();
        }else{
            /* Récupération des données */
            mesTaches=savedInstanceState.getParcelableArrayList(Constantes.LISTE);
        }

        recyclerView =(RecyclerView) v.findViewById(R.id.idList);
        tacheAdapter=new TacheAdapter(mesTaches,interfaceLesTaches);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(tacheAdapter);

        return v;

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof InterfaceLesTaches){
            interfaceLesTaches=(InterfaceLesTaches) context;
        }
    }

    /* Fonction qui envoie vers l'activité AjoutActivity */
    public void ajouterBtn2(){
        Intent intent=new Intent(getView().getContext(),AjoutActivity.class);
        startActivityForResult(intent,Constantes.REQUEST_CODE);
    }

    /* Fonction lancée quand on revient de AjoutActivity et qui permets d'ajouter la tâche donnée */
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if((resultCode==Constantes.CODE_OK)&&(requestCode==Constantes.REQUEST_CODE)){
            Tache t=new Tache(data.getStringExtra(Constantes.TACHE),data.getStringExtra(Constantes.CATEGORIE),data.getStringExtra(Constantes.DUREE),data.getStringExtra(Constantes.DESCRIPTION));
            ajoutTache(t);
        }
    }

    /* Initialisation des tâches lors de la première ouverture de l'application */
    public void initTaches(){
        Tache t1=new Tache("footing","Sport","60","course de Yvan");
        Tache t2=new Tache("travail","Travail","190","Etude pratique");
        Tache t3=new Tache("grand menage","Menage","10","9 metres carrés");
        Tache t4=new Tache("promener le chien","Autre","60","Max se balade");
        Tache t5=new Tache("Hunger Games","Lecture","45","Très bon livre");
        Tache t6=new Tache("Mettre au four","Enfants","60","Petit repas de famille");
        Tache t7=new Tache("Courses","Courses","120","course alcool");
        Tache t8=new Tache("footing 10km","Sport","70","bravo selim -Yvan");
        mesTaches=new ArrayList<Tache>(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8));

    }

    /* Ajout d'une tâche */
    public void ajoutTache(Tache t){
        mesTaches.add(t);
        tacheAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        bundle.putParcelableArrayList(Constantes.LISTE,mesTaches);
    }
}
