package utils;

import appModels.AsylumCentre;

import java.util.ArrayList;

public class AsylumController {

    private static AsylumController instance = null;

    private final ArrayList<AsylumCentre> allAsylumCentres;

    public static AsylumController getInstance() {

        if (instance == null) {
            instance = new AsylumController();
        }
        return instance;
    }

    public ArrayList<AsylumCentre> getAllAsylumCentres() {
        return allAsylumCentres;
    }

    private AsylumController() {
        this.allAsylumCentres = new ArrayList<>();
    }

    public boolean AsylumCentreExists(String streetName) {

        for (AsylumCentre a : allAsylumCentres) {

            if (streetName.equalsIgnoreCase(a.getStreetName())) {
                System.out.println("This asylum centre is already registered.");
                return true;
            }
        }
        return false;
    }

    public void addAsylumCentre(AsylumCentre asylumCentre) {
        allAsylumCentres.add(asylumCentre);
    }
}
