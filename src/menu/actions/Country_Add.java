package menu.actions;

import appModels.Country;
import utils.ClosedQuestion;
import utils.CountryController;
import utils.MyScanner;

public class Country_Add implements IAction{

    @Override
    public void execute() {

        CountryController countryController = CountryController.getInstance();

        String name;
        boolean isSafe;

        System.out.print("Enter name of country: ");
        name = MyScanner.nextLine();

        if (!countryController.countryExists(name)) {

            if (ClosedQuestion.question("Is this country considered 'safe'?")){
                isSafe = true;
            }
            else {
                isSafe = false;
            }
            System.out.println(name + " successfully added!");
            countryController.addCountry(new Country(name, isSafe));
        }
        else {
            System.out.println("This country is already registered.");
        }
    }
}
