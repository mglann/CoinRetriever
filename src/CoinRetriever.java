public class CoinRetriever
{
    public static void main(String[] args)
    {
        UserInterface ui = new UserInterface();
        CoinRetrieverRequest req = new CoinRetrieverRequest();

        while(true)
        {
            String mainResponse = ui.inputMode();
            if (mainResponse.equals("1"))
            {
                System.out.println("Ticker");
            }
            else
            {
                System.out.println("Quit");
                break;
            }
        }
    }
}
