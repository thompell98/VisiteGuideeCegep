package com.example.visiteguideecegep;

import java.util.ArrayList;

public class Intersection {
    Coordonnee coordonnee;
    boolean utilise;
    ArrayList<Integer> numerosIntersectionsReliees = new ArrayList<>();

    public Intersection( float x, float y, int[] numerosIntersectionsReliees) {
        this.coordonnee = new Coordonnee(x, y);
        this.utilise = false;
        for (int cpt = 0; cpt < numerosIntersectionsReliees.length; cpt++)
        {
            this.numerosIntersectionsReliees.add(numerosIntersectionsReliees[cpt]);
        }
    }
}
