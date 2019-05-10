package com.example.visiteguideecegep;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Escalier {
    ArrayList<Intersection> intersections;

    public Escalier(Intersection[] intersections) {
        this.intersections = new ArrayList<>(Arrays.asList(intersections));
    }

    public Intersection getIntersections(int etage) {
        return intersections.get(etage);
    }
}
