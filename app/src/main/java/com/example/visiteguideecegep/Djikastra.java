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
    Intersection[][] lesIntersections = new Intersection[5][22];
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
        lesIntersections[0][0] = new Intersection(70, 695, 1, new int[]{1});
        lesIntersections[0][1] = new Intersection( 130, 695, 1, new int[]{0, 2, 3});
        lesIntersections[0][2] = new Intersection( 130, 720, 1, new int[]{1});
        lesIntersections[0][3] = new Intersection( 180, 695, 1, new int[]{1, 4});
        lesIntersections[0][4] = new Intersection( 350, 695, 2, new int[]{3, 5});
        lesIntersections[0][5] = new Intersection( 420, 695, 2, new int[]{4, 6, 7});
        lesIntersections[0][6] = new Intersection( 420, 630, 2, new int[]{5});
        lesIntersections[0][7] = new Intersection( 562, 695, 2, new int[]{5, 8, 10});
        lesIntersections[0][8] = new Intersection( 800, 695, 3, new int[]{7, 9});
        lesIntersections[0][9] = new Intersection( 800, 645, 3, new int[]{8});
        lesIntersections[0][10] = new Intersection( 562, 600, 2, new int[]{7, 11});
        lesIntersections[0][11] = new Intersection( 562, 510, 2, new int[]{10, 12});
        lesIntersections[0][12] = new Intersection( 562, 420, 4, new int[]{11, 13});
        lesIntersections[0][13] = new Intersection( 562, 280, 4, new int[]{12, 14, 15, 16});
        lesIntersections[0][14] = new Intersection( 562, 240, 4, new int[]{13});
        lesIntersections[0][15] = new Intersection( 630, 260, 4, new int[]{13, 16});
        lesIntersections[0][16] = new Intersection( 800, 250, 4, new int[]{13, 15});
        lesIntersections[1][0] = new Intersection( 70, 695, 1, new int[]{1});
        lesIntersections[1][1] = new Intersection( 160, 695, 1, new int[]{0, 2, 5});
        lesIntersections[1][2] = new Intersection( 160, 580, 1, new int[]{1, 3});
        lesIntersections[1][3] = new Intersection( 160, 450, 1, new int[]{2, 4});
        lesIntersections[1][4] = new Intersection( 160, 350, 1, new int[]{3});
        lesIntersections[1][5] = new Intersection( 500, 695, 2, new int[]{1, 6, 7});
        lesIntersections[1][6] = new Intersection( 500, 630, 2, new int[]{5, 18});
        lesIntersections[1][7] = new Intersection( 575, 695, 2, new int[]{5, 8, 18});
        lesIntersections[1][8] = new Intersection( 800, 695, 3, new int[]{7, 9, 10});
        lesIntersections[1][9] = new Intersection( 880, 695, 3, new int[]{8});
        lesIntersections[1][10] = new Intersection( 800, 630, 3, new int[]{8, 18});
        lesIntersections[1][11] = new Intersection( 575, 510, 2, new int[]{12, 18});
        lesIntersections[1][12] = new Intersection( 575, 300, 4, new int[]{11, 13, 15});
        lesIntersections[1][13] = new Intersection( 630, 290, 4, new int[]{12, 14});
        lesIntersections[1][14] = new Intersection( 720, 265, 4, new int[]{13});
        lesIntersections[1][15] = new Intersection( 575, 250, 4, new int[]{12, 16});
        lesIntersections[1][16] = new Intersection( 635, 250, 4, new int[]{15, 17});
        lesIntersections[1][17] = new Intersection( 635, 250, 4, new int[]{16});
        lesIntersections[1][18] = new Intersection( 575, 630, 2, new int[]{6, 7, 10, 11});
        lesIntersections[2][0] = new Intersection( 70, 695, 1, new int[]{1});
        lesIntersections[2][1] = new Intersection( 160, 695, 1, new int[]{0, 2, 3, 8});
        lesIntersections[2][2] = new Intersection( 160, 760, 1, new int[]{1});
        lesIntersections[2][3] = new Intersection( 160, 600, 1, new int[]{1, 4});
        lesIntersections[2][4] = new Intersection( 160, 490, 1, new int[]{3, 5});
        lesIntersections[2][5] = new Intersection( 160, 370, 1, new int[]{4, 6});
        lesIntersections[2][6] = new Intersection( 160, 260, 1, new int[]{5, 7});
        lesIntersections[2][7] = new Intersection( 160, 150, 1, new int[]{6});
        lesIntersections[2][8] = new Intersection( 335, 695, 2, new int[]{1, 9});
        lesIntersections[2][9] = new Intersection( 480, 695, 2, new int[]{8, 10, 11});
        lesIntersections[2][10] = new Intersection( 480, 630, 2, new int[]{9});
        lesIntersections[2][11] = new Intersection( 580, 695, 2, new int[]{9, 12});
        lesIntersections[2][12] = new Intersection( 705, 695, 3, new int[]{11, 13, 17});
        lesIntersections[2][13] = new Intersection( 790, 695, 3, new int[]{12, 14, 16});
        lesIntersections[2][14] = new Intersection( 880, 695, 3, new int[]{13, 15});
        lesIntersections[2][15] = new Intersection( 970, 695, 3, new int[]{14});
        lesIntersections[2][16] = new Intersection( 790, 630, 3, new int[]{13});
        lesIntersections[2][17] = new Intersection( 705, 550, 3, new int[]{12, 18});
        lesIntersections[2][18] = new Intersection( 705, 260, 4, new int[]{17, 19, 20});
        lesIntersections[2][19] = new Intersection( 880, 200, 4, new int[]{18});
        lesIntersections[2][20] = new Intersection( 580, 260, 4, new int[]{18, 21});
        lesIntersections[2][21] = new Intersection( 580, 200, 4, new int[]{20});
        lesIntersections[3][0] = new Intersection( 70, 660, 1, new int[]{1});
        lesIntersections[3][1] = new Intersection( 165, 660, 1, new int[]{0, 2, 3, 7});
        lesIntersections[3][2] = new Intersection( 165, 750, 1, new int[]{1});
        lesIntersections[3][3] = new Intersection( 165, 560, 1, new int[]{1, 4});
        lesIntersections[3][4] = new Intersection( 165, 470, 1, new int[]{3, 5});
        lesIntersections[3][5] = new Intersection( 165, 370, 1, new int[]{4, 6});
        lesIntersections[3][6] = new Intersection( 165, 280, 1, new int[]{5});
        lesIntersections[3][7] = new Intersection( 300, 660, 2, new int[]{1, 8});
        lesIntersections[3][8] = new Intersection( 380, 660, 2, new int[]{7, 9});
        lesIntersections[3][9] = new Intersection( 480, 660, 2, new int[]{8, 10, 11});
        lesIntersections[3][10] = new Intersection( 480, 595, 2, new int[]{9});
        lesIntersections[3][11] = new Intersection( 560, 660, 2, new int[]{9, 12});
        lesIntersections[3][12] = new Intersection( 640, 660, 2, new int[]{11, 13});
        lesIntersections[3][13] = new Intersection( 720, 660, 3, new int[]{12, 14});
        lesIntersections[3][14] = new Intersection( 790, 660, 3, new int[]{13, 15, 16});
        lesIntersections[3][15] = new Intersection( 790, 595, 3, new int[]{14});
        lesIntersections[3][16] = new Intersection( 880, 660, 3, new int[]{14, 17});
        lesIntersections[3][17] = new Intersection( 935, 660, 3, new int[]{16});
        lesIntersections[3][18] = new Intersection( 640, 170, 4, new int[]{19});
        lesIntersections[3][19] = new Intersection( 880, 90, 4, new int[]{18});
        lesIntersections[4][0] = new Intersection( 70, 660, 1, new int[]{1});
        lesIntersections[4][1] = new Intersection( 155, 660, 1, new int[]{0, 2, 3, 8});
        lesIntersections[4][2] = new Intersection( 155, 750, 1, new int[]{1});
        lesIntersections[4][3] = new Intersection( 155, 580, 1, new int[]{1, 4});
        lesIntersections[4][4] = new Intersection( 155, 425, 1, new int[]{3, 5});
        lesIntersections[4][5] = new Intersection( 155, 380, 1, new int[]{4, 6});
        lesIntersections[4][6] = new Intersection( 215, 380, 1, new int[]{5, 7});
        lesIntersections[4][7] = new Intersection( 215, 300, 1, new int[]{6});
        lesIntersections[4][8] = new Intersection( 310, 660, 2, new int[]{1, 9});
        lesIntersections[4][9] = new Intersection( 410, 660, 2, new int[]{8, 10});
        lesIntersections[4][10] = new Intersection( 480, 660, 2, new int[]{9, 11, 12});
        lesIntersections[4][11] = new Intersection( 480, 600, 2, new int[]{10});
        lesIntersections[4][12] = new Intersection( 560, 660, 3, new int[]{10, 13});
        lesIntersections[4][13] = new Intersection( 650, 660, 3, new int[]{12, 14});
        lesIntersections[4][14] = new Intersection( 730, 660, 3, new int[]{13, 15});
        lesIntersections[4][15] = new Intersection( 790, 660, 3, new int[]{14, 16, 17});
        lesIntersections[4][16] = new Intersection( 790, 600, 3, new int[]{15});
        lesIntersections[4][17] = new Intersection( 870, 660, 3, new int[]{15, 18});
        lesIntersections[4][18] = new Intersection( 960, 660, 4, new int[]{17});
        lesIntersections[4][19] = new Intersection( 640, 170, 4, new int[]{20});
        lesIntersections[4][20] = new Intersection( 880, 90, 4, new int[]{19});
    }

    private void creerLesEscaliers(){
        Intersection[] intersectionsEscalier1 = {lesIntersections[0][0], lesIntersections[1][0], lesIntersections[2][0], lesIntersections[3][0], lesIntersections[4][0]};
        Intersection[] intersectionsEscalier2 = {lesIntersections[0][6], lesIntersections[1][6], lesIntersections[2][10], lesIntersections[3][10], lesIntersections[4][11]};
        Intersection[] intersectionsEscalier3 = {lesIntersections[0][9], lesIntersections[1][10], lesIntersections[2][16], lesIntersections[3][15], lesIntersections[4][16]};
        Intersection[] intersectionsEscalier4 = {lesIntersections[0][15], lesIntersections[1][13], lesIntersections[2][18], lesIntersections[3][18], lesIntersections[4][19]};
        lesEscaliers[0] = new Escalier(intersectionsEscalier1);
        lesEscaliers[1] = new Escalier(intersectionsEscalier2);
        lesEscaliers[2] = new Escalier(intersectionsEscalier3);
        lesEscaliers[3] = new Escalier(intersectionsEscalier4);
    }

    private double calculerDistanceTotalTrajet(ArrayList<Intersection> leTrajet){
        double distanceTotal = 0;
        for (int cpt = 0; cpt < leTrajet.size() - 1; cpt++){
            distanceTotal += calculerDistanceEntreDeuxPoints(leTrajet.get(cpt), leTrajet.get(cpt + 1));
        }
        return distanceTotal;
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
            int nombreEscalier = lesEscaliers.length;
            if (etageDepart == 4 || etageDepart == 3 || etageVoulu == 4 || etageVoulu == 3){
                nombreEscalier = 3;
            }
            for (int cpt = 0; cpt < nombreEscalier; cpt++){
                Intersection escalierEtageDepart = lesEscaliers[cpt].intersections.get(etageDepart);
                Intersection escalierEtageArrivee = lesEscaliers[cpt].intersections.get(etageVoulu);
                ArrayList<Intersection> trajetEtagePrincipalCourant = obtenirCheminEtage(etageDepart, intersectionDepart, escalierEtageDepart);
                ArrayList<Intersection> trajetEtageFinalCourant = obtenirCheminEtage(etageVoulu, escalierEtageArrivee, intersectionATrouver);
                if (cpt == 0){
                    this.trajetEtagePrincipal = trajetEtagePrincipalCourant;
                    this.trajetEtageFinal = trajetEtageFinalCourant;
                }
                else{
                    if (calculerDistanceTotalTrajet(trajetEtagePrincipalCourant) + calculerDistanceTotalTrajet(trajetEtageFinalCourant) <
                        calculerDistanceTotalTrajet(this.trajetEtagePrincipal) + calculerDistanceTotalTrajet(this.trajetEtageFinal)){
                        this.trajetEtagePrincipal = trajetEtagePrincipalCourant;
                        this.trajetEtageFinal = trajetEtageFinalCourant;
                    }
                }
            }
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
