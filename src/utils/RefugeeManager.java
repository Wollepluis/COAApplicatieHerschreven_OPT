package utils;

import userClasses.Refugee;

import java.util.ArrayList;

public class RefugeeManager {

    private final ArrayList<Refugee> newRefugees = new ArrayList<>();
    private final ArrayList<Refugee> registeredRefugees = new ArrayList<>();

    public boolean checkIfRegistered(String name) {

        for (Refugee r : registeredRefugees) {

            if (name.equalsIgnoreCase(r.getName())) {
                System.out.println("This refugee has already been registered.");
                return true;
            }
        }
        return false;
    }

    public void registerRefugee(Refugee refugee) {
        registeredRefugees.add(refugee);
    }

    public void addNewRefugee(Refugee refugee) {
        newRefugees.add(refugee);
    }
}
