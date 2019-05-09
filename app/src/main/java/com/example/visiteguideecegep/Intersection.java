package com.example.visiteguideecegep;

import java.util.ArrayList;

public class Intersection {
    int numero;
    double x;
    double y;
    boolean utilise;
    boolean escalier;
    ArrayList<Integer> numerosIntersectionsReliees = new ArrayList<>();

    public Intersection(int numero, float x, float y, boolean escalier, int[] numerosIntersectionsReliees) {
        this.numero = numero;
        this.x = x;
        this.y = y;
        this.escalier = escalier;
        this.utilise = false;

        for (int cpt = 0; cpt < numerosIntersectionsReliees.length; cpt++)
        {
            this.numerosIntersectionsReliees.add(numerosIntersectionsReliees[cpt]);
        }
    }
}
