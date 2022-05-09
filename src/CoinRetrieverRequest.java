import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class CoinRetrieverRequest
{
    private String symbolUrl =  "https://api.cryptonator.com/api/currencies";
    private static final String URL = "https://api.cryptonator.com/api/ticker/";
    private String symbol;
    private int selectedValue;
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
            Map symbolList = (Map)data.get(i);
            symbols.add((String)symbolList.get("code"));
        }
    }

    public ArrayList<String> getSymbolList()
    {
        return symbols;
    }

    public boolean validateSymbol(String symbolResponse)
    {
        if(symbols.contains(symbolResponse.toUpperCase()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean setSymbol(String symbolResponse)
    {
        symbol =  null;
        boolean valid = validateSymbol(symbolResponse);
        if(valid)
        {
            this.symbol = symbol;
            symbol = symbolResponse;
            return true;
        }

        return false;
    }

    public CoinRetrieverResponse getSymbolData() throws Exception
    {
        String requestURL;
        requestURL = URL + symbol + "-usd";
        URL url = new URL(requestURL);
        System.out.println(requestURL);

        BufferedReader in  = new BufferedReader(new InputStreamReader(url.openStream()));
        java.net.URL jsonData =  url;
        JSONParser parser = new JSONParser();
        //JSONObject data = (JSONObject) (parser.parse(in));
        Map dataTest = (Map)(parser.parse(in));
        //JSONArray data = (JSONArray) dataTest.get("ticker");
        System.out.println(dataTest);
        //Map mainCoinData = (Map)(data.get("ticker"));
        //Double price = (Double)(data.get("price"));

        return null;
    }
}
