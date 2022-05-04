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
            if (mainResponse.toUpperCase().equals("Q"))
            {
                break;
            }
            ui.selectSymbol(req);
            ui.inputSymbol();
            String symbolResponse = ui.inputSymbol();
            req.setSymbol(symbolResponse);
            req.getSymbolData();

            //CoinRetrieverResponse response = req.getCoinData();
        }

    }


}
