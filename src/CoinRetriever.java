import java.io.IOException;

public class CoinRetriever
{
    public static void main(String[] args) throws Exception
    {
        UserInterface ui = new UserInterface();
        CoinRetrieverRequest req = new CoinRetrieverRequest();
        //initialize symbol list from API
        req.getSymbols();

        while(true)
        {
            String mainResponse = ui.inputMode();
            if (mainResponse.equals("Q"))
            {
                System.out.println("Quit");
                break;
            }
            else
            {
                req.setSymbol(mainResponse);
                String apiResponse = req.getData();
                System.out.println("API response:" + apiResponse);
            }
        }
    }
}
