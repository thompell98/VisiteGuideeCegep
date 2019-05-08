package com.example.visiteguideecegep;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Djikastra {
    Intersection lesIntersections[] = new Intersection[9];
    ArrayList<Intersection> meilleurTrajet = new ArrayList<>();
    Intersection intersectionDepart;
    Intersection intersectionATrouver;

    public Djikastra(int numeroIntersectionDepart, int numeroIntersectionATrouver){
        this.ajouterLesIntersections();
        this.intersectionDepart = lesIntersections[numeroIntersectionDepart];
        this.intersectionATrouver = lesIntersections[numeroIntersectionATrouver];
        this.trouverMeilleurChemin();
    }

    public Intersection[] lesIntersections() {
        return lesIntersections;
    }

    public ArrayList<Intersection> meilleurTrajet() {
        return meilleurTrajet;
    }

    private void ajouterLesIntersections() {
        lesIntersections[0] = new Intersection(0, 250, 20, new int[]{1});
        lesIntersections[1] = new Intersection(1, 250, 70, new int[]{0, 2});
        lesIntersections[2] = new Intersection(2, 250, 120, new int[]{1, 3});
        lesIntersections[3] = new Intersection(3, 250, 170, new int[]{2, 4});
        lesIntersections[4] = new Intersection(4, 250, 220, new int[]{3, 5, 6});
        lesIntersections[5] = new Intersection(5, 200, 220, new int[]{4, 7});
        lesIntersections[6] = new Intersection(6, 300, 220, new int[]{4, 8});
        lesIntersections[7] = new Intersection(7, 150, 220, new int[]{5});
        lesIntersections[8] = new Intersection(8, 350, 220, new int[]{6});
    }

    private double calculerDistanceEntreDeuxPoints(Intersection intersection1, Intersection intersection2) {
        return Math.sqrt(Math.pow(intersection2.x - intersection1.x, 2) + Math.pow(intersection2.y - intersection1.y, 2));
    }

    private void trouverMeilleurChemin() {
        final HashMap<Intersection, Double> distances = new HashMap<>();
        HashMap<Intersection, Intersection> precedent = new HashMap<>();
        ArrayList<Intersection> intersections = new ArrayList<>();
        intersections.addAll(Arrays.asList(lesIntersections));
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
                Intersection intersectionDestinationEnTraitement = lesIntersections[numeroIntersectionsReliees];
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
