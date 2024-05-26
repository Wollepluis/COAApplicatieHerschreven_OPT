package menu.actions;

import appModels.Land;
import utils.ClosedQuestion;
import utils.Land_Controller;
import utils.MyScanner;

public class Land_VoegToe implements IAction{

    @Override
    public void execute() {

        Land_Controller landController = Land_Controller.getInstance();

        String naam;
        boolean isVeilig;

        System.out.print("Voer naam van land in: ");
        naam = MyScanner.nextLine();

        Land land = landController.bestaatLand(naam);

        if (land == null) {

            if (ClosedQuestion.question("Is dit land 'veilig'?")){
                isVeilig = true;
            }
            else {
                isVeilig = false;
            }
            System.out.println(naam + " toegevoegd!");
            landController.voegLandToe(new Land(naam, isVeilig));
        }
        else {
            System.out.println("Dit land is al geregistreerd.");
        }
    }
}
