package com.example.visiteguideecegep;

import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Djikastra {
    Intersection[][] lesIntersections = new Intersection[5][19];
    Escalier[]lesEscaliers = new Escalier[4];
    Intersection intersectionDepart;
    Intersection intersectionATrouver;
    ArrayList<Intersection> trajetEtagePrincipal;
    ArrayList<Intersection> trajetEtageFinal;
    int etageDepart;
    int etageVoulu;

    public Djikastra(){
        for (int cpt = 0; cpt < this.lesIntersections.length; cpt++){
            for (int cpt2 = 0; cpt2 < this.lesIntersections[cpt].length; cpt2++){
                lesIntersections[cpt][cpt2] = null;
            }
        }
        this.trajetEtagePrincipal = null;
        this.trajetEtageFinal = null;
        this.intersectionDepart = null;
        this.intersectionATrouver = null;
        this.etageDepart = 0;
        this.etageVoulu = 0;
        this.ajouterLesIntersections();
    }

    public Intersection[][] lesIntersections() {
        return lesIntersections;
    }

    private void ajouterLesIntersections() {
        creerLesIntersections();
        creerLesEscaliers();
    }

    private void creerLesIntersections(){
        lesIntersections[0][0] = new Intersection(70, 690, 1, new int[]{1});
        lesIntersections[0][1] = new Intersection( 130, 690, 1, new int[]{0, 2, 3});
        lesIntersections[0][2] = new Intersection( 130, 720, 1, new int[]{1});
        lesIntersections[0][3] = new Intersection( 180, 690, 1, new int[]{1, 4});
        lesIntersections[0][4] = new Intersection( 350, 690, 2, new int[]{3, 5});
        lesIntersections[0][5] = new Intersection( 420, 690, 2, new int[]{4, 6, 7});
        lesIntersections[0][6] = new Intersection( 420, 630, 2, new int[]{5});
        lesIntersections[0][7] = new Intersection( 562, 690, 2, new int[]{5, 8, 10});
        lesIntersections[0][8] = new Intersection( 800, 690, 3, new int[]{7, 9});
        lesIntersections[0][9] = new Intersection( 800, 645, 3, new int[]{8});
        lesIntersections[0][10] = new Intersection( 562, 600, 2, new int[]{7, 11});
        lesIntersections[0][11] = new Intersection( 562, 510, 2, new int[]{10, 12});
        lesIntersections[0][12] = new Intersection( 562, 420, 4, new int[]{11, 13});
        lesIntersections[0][13] = new Intersection( 562, 280, 4, new int[]{12, 14, 15, 16});
        lesIntersections[0][14] = new Intersection( 562, 240, 4, new int[]{13});
        lesIntersections[0][15] = new Intersection( 630, 260, 4, new int[]{13, 16});
        lesIntersections[0][16] = new Intersection( 800, 250, 4, new int[]{13, 15});
        lesIntersections[1][0] = new Intersection( 70, 690, 1, new int[]{1});
        lesIntersections[1][1] = new Intersection( 160, 690, 1, new int[]{0, 2, 5});
        lesIntersections[1][2] = new Intersection( 160, 580, 1, new int[]{1, 3});
        lesIntersections[1][3] = new Intersection( 160, 450, 1, new int[]{2, 4});
        lesIntersections[1][4] = new Intersection( 160, 350, 1, new int[]{3});
        lesIntersections[1][5] = new Intersection( 500, 690, 2, new int[]{1, 6, 7});
        lesIntersections[1][6] = new Intersection( 500, 630, 2, new int[]{5, 18});
        lesIntersections[1][7] = new Intersection( 575, 690, 2, new int[]{5, 8, 18});
        lesIntersections[1][8] = new Intersection( 800, 690, 3, new int[]{7, 9, 10});
        lesIntersections[1][9] = new Intersection( 880, 690, 3, new int[]{8});
        lesIntersections[1][10] = new Intersection( 800, 630, 3, new int[]{8, 18});
        lesIntersections[1][11] = new Intersection( 575, 510, 2, new int[]{12, 18});
        lesIntersections[1][12] = new Intersection( 575, 300, 4, new int[]{11, 13, 15});
        lesIntersections[1][13] = new Intersection( 630, 290, 4, new int[]{12, 14});
        lesIntersections[1][14] = new Intersection( 720, 265, 4, new int[]{13});
        lesIntersections[1][15] = new Intersection( 575, 250, 4, new int[]{12, 16});
        lesIntersections[1][16] = new Intersection( 635, 250, 4, new int[]{15, 17});
        lesIntersections[1][17] = new Intersection( 635, 250, 4, new int[]{16});
        lesIntersections[1][18] = new Intersection( 575, 630, 2, new int[]{6, 7, 10, 11});
    }

    private void creerLesEscaliers(){
        Intersection[] intersectionsEscalier1 = {lesIntersections[0][0], lesIntersections[1][0]};
        Intersection[] intersectionsEscalier2 = {lesIntersections[0][6], lesIntersections[1][6]};
        Intersection[] intersectionsEscalier3 = {lesIntersections[0][9], lesIntersections[1][10]};
        Intersection[] intersectionsEscalier4 = {lesIntersections[0][15], lesIntersections[1][13]};
        lesEscaliers[0] = new Escalier(intersectionsEscalier1);
        lesEscaliers[1] = new Escalier(intersectionsEscalier2);
        lesEscaliers[2] = new Escalier(intersectionsEscalier3);
        lesEscaliers[3] = new Escalier(intersectionsEscalier4);
    }

    private double calculerDistanceEntreDeuxPoints(Intersection intersection1, Intersection intersection2) {
        return Math.sqrt(Math.pow(intersection2.coordonnee.x - intersection1.coordonnee.x, 2) + Math.pow(intersection2.coordonnee.y - intersection1.coordonnee.y, 2));
    }

    public void trouverMeilleurTrajet(int numeroIntersectionDepart, int numeroIntersectionATrouver, int etageDepart, int etageVoulu){
        this.intersectionDepart = lesIntersections[etageDepart][numeroIntersectionDepart];
        this.intersectionATrouver = lesIntersections[etageVoulu][numeroIntersectionATrouver];
        this.etageDepart = etageDepart;
        this.etageVoulu = etageVoulu;

        if (this.etageDepart == this.etageVoulu){
            this.trajetEtagePrincipal = obtenirCheminEtage(etageDepart, intersectionDepart, intersectionATrouver);
        }
        else{
            Intersection escalierLePlusProcheDepart = lesEscaliers[intersectionATrouver.numeroEscalier - 1].intersections.get(etageDepart);
            Intersection escalierLePlusProcheArrivee = lesEscaliers[intersectionATrouver.numeroEscalier - 1].intersections.get(etageVoulu);
            this.trajetEtagePrincipal = obtenirCheminEtage(etageDepart, intersectionDepart, escalierLePlusProcheDepart);
            this.trajetEtageFinal = obtenirCheminEtage(etageVoulu, escalierLePlusProcheArrivee, intersectionATrouver);
        }
    }

    private ArrayList<Intersection> obtenirCheminEtage(int numeroEtage, Intersection intersectionDepart, Intersection intersectionATrouver) {
        final HashMap<Intersection, Double> distances = new HashMap<>();
        HashMap<Intersection, Intersection> precedent = new HashMap<>();
        ArrayList<Intersection> intersections = new ArrayList<>();
        ArrayList<Intersection> meilleurTrajet = new ArrayList<>();
        for (int cpt = 0; cpt < lesIntersections[numeroEtage].length; cpt++){
            if (lesIntersections[numeroEtage][cpt] != null){
                intersections.add(lesIntersections[numeroEtage][cpt]);
            }
        }
        for(Intersection intersection : intersections){
            distances.put(intersection, Double.MAX_VALUE);
            precedent.put(intersection, null);
        }
        distances.put(intersectionDepart, (double) 0);

        while (intersections.size() != 0) {
            Collections.sort(intersections, new Comparator<Intersection>() {
                @Override
                public int compare(Intersection o1, Intersection o2) {
                    return distances.get(o1).compareTo(distances.get(o2));
                }
            });
            Intersection intersectionATraiter = intersections.get(0);
            intersections.remove(intersectionATraiter);
            for(int numeroIntersectionsReliees : intersectionATraiter.numerosIntersectionsReliees){
                Intersection intersectionDestinationEnTraitement = lesIntersections[numeroEtage][numeroIntersectionsReliees];
                double distanceCourante = distances.get(intersectionATraiter) +  calculerDistanceEntreDeuxPoints(intersectionDestinationEnTraitement, intersectionATraiter);
                if (distanceCourante < distances.get(intersectionDestinationEnTraitement)){
                    distances.put(intersectionDestinationEnTraitement, distanceCourante);
                    precedent.put(intersectionDestinationEnTraitement, intersectionATraiter);
                }
            }
        }

        Intersection intersectionTrajet = intersectionATrouver;
        meilleurTrajet.add(intersectionTrajet);
        while (intersectionTrajet != intersectionDepart) {
            meilleurTrajet.add(precedent.get(intersectionTrajet));
            intersectionTrajet = precedent.get(intersectionTrajet);
        }
        return meilleurTrajet;
    }
}

/*    private void djikastra() {
        if (intersectionDepart.numero < intersectionATrouver.numero) {
            Intersection intersectionTemp = intersectionDepart;
            intersectionDepart = intersectionATrouver;
            intersectionATrouver = intersectionTemp;
        }
        while (connecte == false) {
            if (lesIntersectionsARelier.size() == 0) {
                lesIntersectionsARelier.add(intersectionDepart);
                ajouterProchaineIntersectionAuTrajet(intersectionDepart);
            } else {
                ajouterProchaineIntersectionAuTrajet(lesIntersectionsARelier.get(lesIntersectionsARelier.size() - 1));
            }
        }
        afficherTrajet();
    }

    private void ajouterProchaineIntersectionAuTrajet(Intersection intersectionInitial) {
        for (int cpt = 0; cpt < intersectionInitial.numerosIntersectionsReliees.size(); cpt++) {
            if (intersectionInitial.numerosIntersectionsReliees.get(cpt) == intersectionATrouver.numero) {
                intersectionInitial.utilise = true;
                lesIntersectionsARelier.add(lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)]);
                connecte = true;
            }
        }
        if (connecte != true) {
            Intersection intersectionLaPlusProche = null;
            for (int cpt = 0; cpt < intersectionInitial.numerosIntersectionsReliees.size(); cpt++) {
                if (cpt == 0) {
                    intersectionLaPlusProche = lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)];
                } else if (lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)].utilise == false) {
                    if (calculerDistanceEntreDeuxPoints(intersectionInitial, lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)]) <
                            calculerDistanceEntreDeuxPoints(intersectionInitial, lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt - 1)])) {
                        intersectionLaPlusProche = lesIntersections[intersectionInitial.numerosIntersectionsReliees.get(cpt)];
                    }
                }
            }
            intersectionInitial.utilise = true;
            lesIntersectionsARelier.add(intersectionLaPlusProche);
        }
    }*/
