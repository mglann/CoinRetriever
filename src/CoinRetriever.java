public class CoinRetriever {
    public static void main(String[] args)
    {
        UserInterface ui = new UserInterface();

        while(true)
        {
            String mainResponse = ui.mainMenuPrompt();
            if (mainResponse.equals("1"))
            {
                System.out.println("Did soemthing");
            }
            else if (mainResponse.equals("2"))
            {
                System.out.println("Did something else");
            }
            else
            {
                System.out.println("Bye");
                break;
            }
        }
    }
}
