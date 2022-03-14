public class CoinRetriever {
    public static void main(String[] args)
    {
        CoinRetrieverUserInterface ui = new CoinRetrieverUserInterface();

        while(true)
        {
            String mainResponse = ui.mainMenuPrompt();
            if (mainResponse.equals("1"))
            {
                System.out.println("do something");
            }
            else if (mainResponse.equals("2"))
            {
                System.out.println("do something else");
            }
            else if (mainResponse.equals("3"))
            {
                System.out.println("Quit");

            }
        }
    }
}
