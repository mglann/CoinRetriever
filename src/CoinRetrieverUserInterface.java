import javax.swing.*;
import java.util.*;

public class CoinRetrieverUserInterface {
    private Scanner input = new Scanner(System.in);

    public String mainMenuPrompt()
    {
        boolean validInput = false;
        String response =  null;
        while(!validInput)
        {
            System.out.println("Choose an option:");
            System.out.println("1) Do something");
            System.out.println("2) Do something else");
            System.out.println("Q) Quit");

            response = input.nextLine().toUpperCase();

            if( response.equals("1") || response.equals("2") || response.equals("Q"))
            {
                validInput = true;
            }
            else
            {
                System.out.println("READ THE DIRECTIONS!!!!!");
            }
        }

        return response;
    }
}
