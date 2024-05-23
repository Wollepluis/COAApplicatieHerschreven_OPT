package utils;

import appModels.LocalAuthority;

import java.util.ArrayList;

public class LocalAuthorityManager {

    private static final ArrayList<LocalAuthority> allLocalAuthorities = new ArrayList<>();

    public static boolean hasLocalAuthority(String name) {

        for (LocalAuthority l : allLocalAuthorities) {

            if (name.equalsIgnoreCase(l.getName())) {
                System.out.println("This local authority has already been registered.");
                return true;
            }
        }
        return false;
    }

    public static void addLocalAuthority(LocalAuthority localAuthority) {
        allLocalAuthorities.add(localAuthority);
    }
}
