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
            //ui.inputSymbol();
            boolean validSymbol = false;
            while(!validSymbol)
            {
                String symbolResponse = ui.inputSymbol();
                if(req.setSymbol(symbolResponse))
                {
                    validSymbol = true;
                }

                else
                {
                    ui.displayTickerErrorMessage();
                }
            }
            CoinRetrieverResponse response = req.getSymbolData();
            ui.displayCoinData(response.getPrice(), response.getVolume(), response.getChange());
        }
    }


}
