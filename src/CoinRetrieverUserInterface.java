import javax.swing.*;
import java.util.*;

public class CoinRetrieverUserInterface {
    private Scanner imput = new Scanner(System.in);

    public String mainMenuPrompt()
    {
        boolean validImput = false;
        String response =  null;
        while(!validImput)
        {
            System.out.println("Chose an option");
            System.out.println("do something");
            System.out.println("do something else");
            System.out.println("Q) quit");

            response = imput.nextLine().toUpperCase();

            if(response.equals("1") || response.equals("2") || response.equals("3"))
            {
                validImput = true;
            }
            else
            {
                System.out.println("read the directions");
            }
        }
        return response;
    }
}
