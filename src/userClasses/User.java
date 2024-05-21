package userClasses;

import menu.Menu;

public abstract class User {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public User(String username) {
        this.setUsername(username);
    }

    public boolean login(String username) {
        return this.getUsername().equals(username);
    }

    public abstract Menu getMenu();
}
