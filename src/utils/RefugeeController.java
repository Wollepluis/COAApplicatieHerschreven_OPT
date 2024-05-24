package utils;

import userClasses.Refugee;

import java.util.ArrayList;

public class RefugeeController {

    private static RefugeeController instance = null;

    private final ArrayList<Refugee> newRefugees;
    private final ArrayList<Refugee> registeredRefugees;

    public static RefugeeController getInstance() {

        if (instance == null) {
            instance = new RefugeeController();
        }
        return instance;
    }

    public ArrayList<Refugee> getNewList() {
        return this.newRefugees;
    }

    public ArrayList<Refugee> getRegisteredList() {
        return this.registeredRefugees;
    }

    public Refugee getNewRefugee(String name) {

        for (Refugee r : this.newRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                return r;
            }
        }
        return null;
    }

    public Refugee getRegisteredRefugee(String name) {

        for (Refugee r : this.registeredRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                return r;
            }
        }
        return null;
    }

    public RefugeeController() {
        this.newRefugees = new ArrayList<>();
        this.registeredRefugees = new ArrayList<>();
    }

    public int checkRegistration(String name) {

        for (Refugee r : this.registeredRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                return 1;
            }
        }

        for (Refugee r : this.newRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                return 2;
            }
        }
        return 0;
    }

    public void addNewRefugee(Refugee refugee) {
        this.newRefugees.add(refugee);
    }

    public void registerRefugee(String name) {

        for (Refugee r : this.newRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                this.registeredRefugees.add(r);
                this.newRefugees.remove(r);
            }
        }
    }
}
