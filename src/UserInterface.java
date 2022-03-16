import javax.swing.*;
import java.util.*;

public class UserInterface
{
    private Scanner input;

    public UserInterface()
    {
        input = new Scanner(System.in);
    }

    public String inputMode()
    {
        String mode = "";
        while (true)
        {
            System.out.println("Choose an option:");
            System.out.println("1) Ticker");
            System.out.println("Q) Quit");
            System.out.println();

            mode = input.nextLine().toUpperCase();

            if( mode.equals("1") ||  mode.equals("Q"))
            {
                break;
            }
            else
            {
                //displayErrorMessage
            }
        }

        return mode;
    }
}
