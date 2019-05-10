package com.example.visiteguideecegep;

import java.util.ArrayList;

public class Intersection {
    Coordonnee coordonnee;
    boolean utilise;
    int numeroEscalier;
    ArrayList<Integer> numerosIntersectionsReliees = new ArrayList<>();

    public Intersection( float x, float y, int numeroEscalier, int[] numerosIntersectionsReliees) {
        this.coordonnee = new Coordonnee(x, y);
        this.utilise = false;
        this.numeroEscalier = numeroEscalier;
        for (int cpt = 0; cpt < numerosIntersectionsReliees.length; cpt++)
        {
            this.numerosIntersectionsReliees.add(numerosIntersectionsReliees[cpt]);
        }
    }
}
