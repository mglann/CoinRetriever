import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class CoinRetrieverRequest
{
    private String symbolUrl =  "https://www.cryptonator.com/api/currencies";
    private static final String URL = "https://api.cryptonator.com/api/ticker";
    private String symbol;
    ArrayList<String> symbols =  new ArrayList<String>();

    public void getSymbols() throws Exception
    {
        CoinRetrieverRequest symbol = new CoinRetrieverRequest();
        URL symbolUrl = new URL(symbol.symbolUrl);
        BufferedReader in  = new BufferedReader(new InputStreamReader(symbolUrl.openStream()));
        java.net.URL jsonData =  symbolUrl;
        JSONParser parser =  new JSONParser();
        JSONArray CoinRetrieverRequest = (JSONArray)(parser.parse(in));

        for(int i = 0; i < symbols.size(); i++)
        {
            Map m = (Map)CoinRetrieverRequest.get(i);
            symbols.add("code");
        }
    }

    public void setSymbol(String mainResponse)
    {
        this.symbol = symbol;
    }


    public boolean validateSymbol()
    {
        String urlSymbols = "";
        String getSymbols = symbols.get();
        for(int i = 0; i < symbols.size(); i++)
        {
            if(urlSymbols == getSymbols)
            {
                return true;
            }
        }

    }

    public String getData()
    {
        return "data";
    }
}
