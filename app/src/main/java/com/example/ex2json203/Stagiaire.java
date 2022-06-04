package com.example.ex2json203;

public class Stagiaire {

    private String nom;
    private String filiere;
    private int age;

    public Stagiaire() {
    }

    public Stagiaire(String nom, String filiere, int age) {
        this.nom = nom;
        this.filiere = filiere;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
