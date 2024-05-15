package menu;

import menu.actions.IAction;

public abstract class MenuChoice {

    private int choice;
    private String title;
    private IAction action;

    public void setChoice(int choice) {
        
        if ((choice == -1) || (this.choice == -1)) {
            this.choice = choice;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public int getChoice() {
        return this.choice;
    }

    public MenuChoice(int choice, String title, IAction action) {
        this.setChoice(choice);
        this.setTitle(title);
        this.setAction(action);
    }

    public void showMenuChoice() {
        System.out.printf("[%d] %s%n", this.choice, this.title);
    }

    public void execute() {

        if (action != null) {
            action.execute();
        }
        else {
            System.out.println("This Choice does not execute a command.");
        }
    }
 }