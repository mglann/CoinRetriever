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
                displayErrorMessage("Invalid Input!");
            }
        }
        return mode;
    }

    public String inputTicker()
    {
        System.out.println("Enter a Ticker:");
        System.out.println("For example: BTC");
        System.out.println();
        String ticker = input.nextLine();
        return ticker;
    }

    public void displayTickerErrorMessage()
    {
        String error = "Invalid Ticker, Please try a new Ticker";
        displayErrorMessage(error);
    }

    public void displayErrorMessage(String msg)
    {
        System.out.println("************ERROR************");
        System.out.println(msg);
    }

    public void displayCoinData(double currentPrice)
    {
        System.out.println("Current Price:" + currentPrice);
        System.out.println();
    }
}
