import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class CoinRetrieverRequest
{
    private String symbolUrl =  "https://api.cryptonator.com/api/currencies";
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
        Map CoinRetrieverRequest = (Map)(parser.parse(in));
        JSONArray data = (JSONArray) CoinRetrieverRequest.get("rows");

        for(int i = 0; i < data.size(); i++)
        {
            Map symbolData = (Map)data.get(i);
            symbols.add((String)symbolData.get("code"));
        }
    }

    public boolean validateSymbol(String mainResponse)
    {
        if(symbols.contains(mainResponse))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String setSymbol(String mainResponse)
    {
        boolean valid = validateSymbol(symbol);
        if(true)
        {
            this.symbol = symbol;
        }
        return symbol;
    }

    public CoinRetrieverResponse getCoinData() throws Exception
    {
        String requestURL;
        requestURL = URL + symbol + "-usd";
        System.out.println(requestURL);
        return null;
    }
}
