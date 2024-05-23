package menu;

import menu.actions.IAction;

public class MenuChoice {

    private int choice;
    private String title;
    private boolean extraWhiteLine;
    private IAction action;

    public void setChoice(int choice) {
        
        if ((choice == -1) || (this.choice == -1)) {
            this.choice = choice;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExtraWhiteLine(boolean extraWhiteLine) {
        this.extraWhiteLine = extraWhiteLine;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public int getChoice() {
        return this.choice;
    }

    public MenuChoice(int choice, String title, boolean extraWhiteLine, IAction action) {
        this.setChoice(-1);
        this.setChoice(choice);
        this.setTitle(title);
        this.setExtraWhiteLine(extraWhiteLine);
        this.setAction(action);
    }

    public MenuChoice(int choice, String title, IAction action) {
        this(-1, title, false, action);
    }

    public MenuChoice(String title, IAction action) {
        this(-1, title, false, action);
    }

    public void showMenuChoice() {

        if (extraWhiteLine) {
            System.out.println();
        }
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