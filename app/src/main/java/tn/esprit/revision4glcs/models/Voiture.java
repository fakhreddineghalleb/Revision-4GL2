package tn.esprit.revision4glcs.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "voiture")
public class Voiture {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int image;
    private String marque, model, etat;
    private double prix;

    @Ignore
    public Voiture() {
    }

    @Ignore
    public Voiture(int image, String marque, String model, String etat, double prix) {
        this.image = image;
        this.marque = marque;
        this.model = model;
        this.etat = etat;
        this.prix = prix;
    }

    public Voiture(int id, int image, String marque, String model, String etat, double prix) {
        this.id = id;
        this.image = image;
        this.marque = marque;
        this.model = model;
        this.etat = etat;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
