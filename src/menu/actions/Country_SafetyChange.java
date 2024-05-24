package menu.actions;

import utils.ClosedQuestion;
import utils.CountryController;

public class Country_SafetyChange implements IAction {

    public String printSafety(boolean safety) {

        if (safety) {
            return "safe";
        }
        else {
            return "not safe";
        }
    }

    @Override
    public void execute() {

        CountryController countryController = CountryController.getInstance();

        String countryName = countryController.getActiveCountry().getName();
        boolean safety = countryController.getActiveCountry().getSafe();

        if (ClosedQuestion.question("Do you want to switch " + countryName + "'s safety from '" + printSafety(safety) + "' to '" + printSafety(!safety) + "'?")){
            countryController.getActiveCountry().setSafe(!safety);
            System.out.println(countryName + "'s safety set to '" + printSafety(!safety) + "'.");
        }
        else {
            System.out.println(countryName + "'s safety not switched");
        }


    }
}
