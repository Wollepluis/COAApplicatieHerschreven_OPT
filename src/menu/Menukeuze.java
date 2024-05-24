package menu;

import menu.actions.IAction;

public class Menukeuze {

    private int keuze;
    private String titel;
    private boolean extraWhiteLine;
    private IAction action;

    public void setKeuze(int keuze) {
        
        if ((keuze == -1) || (this.keuze == -1)) {
            this.keuze = keuze;
        }
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setExtraWhiteLine(boolean extraWhiteLine) {
        this.extraWhiteLine = extraWhiteLine;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public int getKeuze() {
        return this.keuze;
    }

    public Menukeuze(int keuze, String titel, boolean extraWhiteLine, IAction action) {
        this.setKeuze(-1);
        this.setKeuze(keuze);
        this.setTitel(titel);
        this.setExtraWhiteLine(extraWhiteLine);
        this.setAction(action);
    }

    public Menukeuze(int keuze, String titel, IAction action) {
        this(-1, titel, false, action);
    }

    public Menukeuze(String titel, IAction action) {
        this(-1, titel, false, action);
    }

    public void toonMenukeuze() {

        if (extraWhiteLine) {
            System.out.println();
        }
        System.out.printf("[%d] %s%n", this.keuze, this.titel);
    }

    public void execute() {

        if (action != null) {
            action.execute();
        }
        else {
            System.out.println("Deze keuze voert geen actie uit.");
        }
    }
 }