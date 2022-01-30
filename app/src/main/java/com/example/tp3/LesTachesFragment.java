package com.example.tp3;

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
    private List<Tache> mesTaches;
    private TacheAdapter tacheAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=inflater.inflate(R.layout.layout_fragment_list_tache,container,false);

        initTaches();

        recyclerView =(RecyclerView) v.findViewById(R.id.idList);
        tacheAdapter=new TacheAdapter(mesTaches);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(tacheAdapter);

        return v;

    }

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

    public void ajoutTache(Tache t){
        mesTaches.add(t);
        tacheAdapter.notifyDataSetChanged();
    }

}
