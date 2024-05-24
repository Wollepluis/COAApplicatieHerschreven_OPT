package utils;

import appModels.Land;

import java.util.ArrayList;

public class Land_Controller {

    private static Land_Controller instance = null;

    private Land actiefLand;
    private final ArrayList<Land> alleLanden;

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

    public ArrayList<Land> getAlleLanden() {
        return alleLanden;
    }

    public void setActiefLand(String actiefLand) {

        for (Land l : alleLanden) {

            if (actiefLand.equalsIgnoreCase(l.getNaam())) {
                this.actiefLand = l;
            }
        }
    }

    private Land_Controller() {
        this.alleLanden = new ArrayList<>();
    }

    public boolean landBestaat(String naam) {

        for (Land l : alleLanden) {

            if (naam.equalsIgnoreCase(l.getNaam())) {
                return true;
            }
        }
        return false;
    }

    public void voegLandToe(Land land) {
        alleLanden.add(land);
    }
}
