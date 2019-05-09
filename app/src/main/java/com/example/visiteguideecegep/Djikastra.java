package com.example.visiteguideecegep;

import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Djikastra {
    Intersection[][] lesIntersections;
    Intersection intersectionDepart;
    Intersection intersectionATrouver;
    ArrayList<Intersection> trajetEtagePrincipal;
    ArrayList<Intersection> trajetEtageFinal;
    int etageDepart;
    int etageVoulu;

    public Djikastra(){
        this.lesIntersections = new Intersection[4][17];
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
        lesIntersections[0][0] = new Intersection(0, 70, 690, false, new int[]{1});
        lesIntersections[0][1] = new Intersection(1, 130, 690, false, new int[]{0, 2, 3});
        lesIntersections[0][2] = new Intersection(2, 130, 720, false, new int[]{1});
        lesIntersections[0][3] = new Intersection(3, 180, 690, false, new int[]{1, 4});
        lesIntersections[0][4] = new Intersection(4, 350, 690, false, new int[]{3, 5});
        lesIntersections[0][5] = new Intersection(5, 420, 690, false, new int[]{4, 6, 7});
        lesIntersections[0][6] = new Intersection(6, 420, 630, false, new int[]{5});
        lesIntersections[0][7] = new Intersection(7, 562, 690, false, new int[]{5, 8, 10});
        lesIntersections[0][8] = new Intersection(8, 800, 690, false, new int[]{7, 9});
        lesIntersections[0][9] = new Intersection(9, 800, 645, false, new int[]{8});
        lesIntersections[0][10] = new Intersection(10, 562, 600, false, new int[]{7, 11});
        lesIntersections[0][11] = new Intersection(11, 562, 510, false, new int[]{10, 12});
        lesIntersections[0][12] = new Intersection(12, 562, 420, false, new int[]{11, 13});
        lesIntersections[0][13] = new Intersection(13, 562, 280, false, new int[]{12, 14, 15});
        lesIntersections[0][14] = new Intersection(14, 562, 240, false, new int[]{13});
        lesIntersections[0][15] = new Intersection(15, 630, 260, false, new int[]{13, 16});
        lesIntersections[0][16] = new Intersection(16, 800, 250, false, new int[]{15});
    }

    private double calculerDistanceEntreDeuxPoints(Intersection intersection1, Intersection intersection2) {
        return Math.sqrt(Math.pow(intersection2.x - intersection1.x, 2) + Math.pow(intersection2.y - intersection1.y, 2));
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

        }
    }

    private ArrayList<Intersection> obtenirCheminEtage(int numeroEtage, Intersection intersectionDepart, Intersection intersectionATrouver) {
        final HashMap<Intersection, Double> distances = new HashMap<>();
        HashMap<Intersection, Intersection> precedent = new HashMap<>();
        ArrayList<Intersection> intersections = new ArrayList<>();
        ArrayList<Intersection> meilleurTrajet = new ArrayList<>();
        for (Intersection[] array : lesIntersections) {
            for (int cpt = 0; cpt < array.length; cpt++){
                if (array[cpt] != null){
                    intersections.add(array[cpt]);
                }
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
