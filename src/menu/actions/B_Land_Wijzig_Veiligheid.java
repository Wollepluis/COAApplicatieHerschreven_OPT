package menu.actions;

import utils.ClosedQuestion;
import utils.Land_Controller;

public class B_Land_Wijzig_Veiligheid implements IAction {

    public String printVeiligheid(boolean veiligheid) {

        if (veiligheid) {
            return "veilig";
        }
        else {
            return "onveilig";
        }
    }

    @Override
    public void execute() {
        Land_Controller landController = Land_Controller.getInstance();

        String landNaam = landController.getActiefLand().getNaam();
        boolean veiligheid = landController.getActiefLand().isVeilig();

        if (ClosedQuestion.question("Wil je " + landNaam + "s veiligheid veranderen van '" + printVeiligheid(veiligheid) + "' naar '" + printVeiligheid(!veiligheid) + "'?")){
            landController.getActiefLand().setVeilig(!veiligheid);
            System.out.println(landNaam + " staat nu geregistreerd als '" + printVeiligheid(!veiligheid) + "'.");
        }
        else {
            System.out.println("Wijziging geannuleerd");
        }
    }
}
