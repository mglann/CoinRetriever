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

        //URLConnection cf = symbolUrl.openConnection();
        //cf.getRequestProperties("cookie");
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

        URLConnection hc = url.openConnection();
        hc.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.54 Safari/537.36");
        hc.setRequestProperty("method", "get");
        hc.setRequestProperty("cookie", "cf_clearance=31a5iWqPajSodMw63bYTTsk3sucU0IjhK4sgTgFTEXw-1652210112-0-150");
        hc.connect();

        //this is the request to our URL and it returns an text input stream that we can read from
        BufferedReader in = new BufferedReader(new InputStreamReader(hc.getInputStream()));
        JSONParser parser = new JSONParser();
        JSONObject symbolData = (JSONObject)parser.parse(in);
        //String json = "{\"ticker\":{\"base\":\"BTC\",\"target\":\"USD\",\"price\":\"31224.88974718\",\"volume\":\"65177.85871621\",\"change\":\"-45.41895185\"},\"timestamp\":1652130724,\"success\":true,\"error\":\"\"}";
        //Map data = (Map)(parser.parse(in));
        Map mainSymbolData = (Map)symbolData.get("ticker");
        String price1 = (String)mainSymbolData.get("price");
        String volume1 = (String)mainSymbolData.get("volume");
        String change1 = (String)mainSymbolData.get("change");

        double price = Double.parseDouble(price1);
        double volume = Double.parseDouble(volume1);
        double change = Double.parseDouble(change1);

        CoinRetrieverResponse response =  new CoinRetrieverResponse(price, volume, change);
        return response;
    }
}
