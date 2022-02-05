package com.example.tp3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TacheAdapter extends RecyclerView.Adapter<TacheAdapter.MyViewHolder> {
    protected List<Tache> mesTaches;
    protected InterfaceLesTaches interfaceLesTaches;
    public TacheAdapter(List<Tache> l, InterfaceLesTaches inter){
        mesTaches=l;
        interfaceLesTaches=inter;
    }
    public TacheAdapter(List<Tache> l){
        mesTaches=l;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNom;
        public ImageView img;

        public MyViewHolder(View view){
            super(view);
            tvNom=(TextView) view.findViewById(R.id.tvNom);
            img=(ImageView) view.findViewById(R.id.imageView);
        }

    }

    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View tacheView=layoutInflater.inflate(R.layout.tache,parent,false);
        return new MyViewHolder(tacheView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        final TacheAdapter adapter = this;
        Tache tache = mesTaches.get(position);
        holder.tvNom.setText(tache.getNom());
        switch (tache.getCategorie()) {
            case Sport: {
                holder.img.setImageResource(R.drawable.sport);
                break;
            }
            case Enfants: {
                holder.img.setImageResource(R.drawable.enfant);
                break;
            }
            case Courses: {
                holder.img.setImageResource(R.drawable.courses);
                break;
            }
            case Menage: {
                holder.img.setImageResource(R.drawable.menage);
                break;
            }
            case Lecture: {
                holder.img.setImageResource(R.drawable.lecture);
                break;
            }
            case Travail: {
                holder.img.setImageResource(R.drawable.travail);
                break;
            }
            case Autre: {
                holder.img.setImageResource(R.drawable.point_interro_);
                break;
            }
        }

        /* Listener Clic rapide qui affiche les informations liées à la tâche selectionée */
        holder.itemView.setOnClickListener((view) -> {
            interfaceLesTaches.tacheSelectionne(tache);
        });

        /* Listener clic long qui lance une pop up demandant si l'utilisateur souhaite vraiment supprimer la tâche, si oui la supprime */
        holder.itemView.setOnLongClickListener((view) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setMessage(R.string.confirmationSupr)
                    .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            mesTaches.remove(tache);
                            adapter.notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
            builder.create().show();
            return true;
        });
    }



    @Override
    public int getItemCount() {
        return mesTaches.size();
    }
}
