package utils;

import userClasses.Refugee;

import java.util.ArrayList;

public class RefugeeManager {

    private static final ArrayList<Refugee> newRefugees = new ArrayList<>();
    private static final ArrayList<Refugee> registeredRefugees = new ArrayList<>();

    public static ArrayList<Refugee> getNewList() {
        return newRefugees;
    }

    public static ArrayList<Refugee> getRegisteredList() {
        return registeredRefugees;
    }

    public static Refugee getNewRefugee(String name) {

        for (Refugee r : newRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                return r;
            }
        }
        return null;
    }

    public static Refugee getRegisteredRefugee(String name) {

        for (Refugee r : registeredRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                return r;
            }
        }
        return null;
    }

    public static int checkRegistration(String name) {

        for (Refugee r : registeredRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                return 1;
            }
        }

        for (Refugee r : newRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                return 2;
            }
        }
        return 0;
    }

    public static void addNewRefugee(Refugee refugee) {
        newRefugees.add(refugee);
    }

    public static void registerRefugee(String name) {

        for (Refugee r : newRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                registeredRefugees.add(r);
                newRefugees.remove(r);
            }
        }
    }
}
