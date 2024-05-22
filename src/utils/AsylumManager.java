package utils;

import appModels.AsylumCentre;

import java.util.ArrayList;

public class AsylumManager {

    private static final ArrayList<AsylumCentre> allAsylumCentres = new ArrayList<>();

    public static boolean hasAsylumCentre(String streetName) {

        for (AsylumCentre a : allAsylumCentres) {

            if (streetName.equalsIgnoreCase(a.getStreetName())) {
                System.out.println("This asylum centre is already registered.");
                return true;
            }
        }
        return false;
    }

    public static void addAsylumCentre(AsylumCentre asylumCentre) {
        allAsylumCentres.add(asylumCentre);
    }
}
