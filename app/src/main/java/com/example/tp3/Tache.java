package com.example.tp3;

import android.os.Parcel;
import android.os.Parcelable;

public class Tache implements Parcelable {
    private String nom;
    private int duree;
    private String description;
    private Categorie categorie;

    /* Constructeur depuis une parcel */
    protected Tache(Parcel in) {
        nom = in.readString();
        duree = in.readInt();
        description = in.readString();
        categorie = Categorie.valueOf(in.readString());
    }

    public static final Tache.Creator<Tache> CREATOR = new Creator<Tache>() {
        @Override
        public Tache createFromParcel(Parcel in) {
            return new Tache(in);
        }

        @Override
        public Tache[] newArray(int size) {
            return new Tache[size];
        }
    };

    @Override
    public int describeContents() {
        return CONTENTS_FILE_DESCRIPTOR;
    }

    /* Méthode pour remplir une parcel avec une Tâche */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeInt(duree);
        parcel.writeString(description);
        parcel.writeString(categorie.name());
    }

    public enum Categorie {
        Autre, Travail, Sport, Menage, Lecture, Enfants, Courses
    }

    public Tache (String n){
        nom=n;
        duree=0;
        description="";
        categorie=Categorie.Autre;
    }

    public Tache(String n, String cat, String d, String desc){
        nom=n;
        categorie=Categorie.valueOf(cat);
        duree= Integer.parseInt(d);
        description=desc;
    }

    public Tache(String n, Categorie cat, int d, String desc){
        nom=n;
        categorie=cat;
        duree=d;
        description=desc;
    }

    public String getNom(){
        return nom;
    }

    public int getDuree(){
        return duree;
    }

    public Categorie getCategorie(){
        return categorie;
    }

    public String getDescription(){
        return description;
    }
}
