package utils;

import appModels.Land;

import java.util.ArrayList;

public class Land_Controller {

    private static Land_Controller instance = null;

    private Land actiefLand;
    private final ArrayList<Land> alleLanden = new ArrayList<>();;

    public static Land_Controller getInstance() {

        if (instance == null) {
            instance = new Land_Controller();
        }
        return instance;
    }

    public Land getActiefLand() {
        return actiefLand;
    }

    public void resetActiefLand() {
        actiefLand = null;
    }

    public void setActiefLand(String actiefLand) {

        for (Land l : this.alleLanden) {

            if (actiefLand.equalsIgnoreCase(l.getNaam())) {
                this.actiefLand = l;
            }
        }
    }

    public ArrayList<Land> getAlleLanden() {
        return alleLanden;
    }

    public Land getLand(String landNaam) {

        for (Land l : this.alleLanden) {

            if (landNaam.equalsIgnoreCase(l.getNaam())) {
                return l;
            }
        }
        return null;
    }

    public void voegLandToe(Land land) {
        this.alleLanden.add(land);
    }
}
