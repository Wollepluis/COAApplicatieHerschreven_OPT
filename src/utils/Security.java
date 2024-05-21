package utils;

import userClasses.User;

public class Security {

    private static Security instance = null;
    private User activeUser;

    private void setActiveUser(User user) {
        this.activeUser = user;
    }

    private Security() {
        setActiveUser(null);
    }

    public static Security getInstance() {

        if (instance == null) {
            instance = new Security();
        }
        return instance;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public boolean isLoggedIn() {
        return activeUser != null;
    }

    public User login() {
        Seeder seeder = Seeder.getInstance();

        boolean loggedIn = false;

        System.out.println("Enter username: ");

        while (!loggedIn) {
            String username = MyScanner.nextLine();
            User user = seeder.getUser(username);

            if (user != null) {
                setActiveUser(user);
                return user;
            }
            System.out.println("Unknown user. Try again.");
        }
        return null;
    }

    public void logout() {
        setActiveUser(null);
    }
}
