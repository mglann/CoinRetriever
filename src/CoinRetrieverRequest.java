import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class CoinRetrieverRequest
{
    UserInterface ui = new UserInterface();

    private String symbolUrl =  "https://api.cryptonator.com/api/currencies";
    private static final String URL = "https://api.cryptonator.com/api/ticker/";
    private String symbol;
    private int selectedValue;
    private String cookie;
    ArrayList<String> symbols =  new ArrayList<String>();

    public void getSymbols() throws Exception
    {
        System.out.println(symbolUrl);
        URL url = new URL(symbolUrl);
        URLConnection hc = url.openConnection();

        //hc.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36");
        hc.setRequestProperty("method", "get");
        hc.connect();

//this is the request to our URL and it returns an text input stream that we can read from
        BufferedReader in = new BufferedReader(
                new InputStreamReader(hc.getInputStream()));

        String cookies = hc.getRequestProperty("cookie");
        //setCookie(cookies);
        JSONParser parser =  new JSONParser();
        Map CoinRetrieverRequest = (Map)(parser.parse(in));
        JSONArray data = (JSONArray) CoinRetrieverRequest.get("rows");

        for(int i = 0; i < data.size(); i++)
        {
            Map symbolList = (Map)data.get(i);
            symbols.add((String)symbolList.get("code"));
        }
        /*
        URL symbolUrl = new URL(this.symbolUrl);
        URLConnection cf = symbolUrl.openConnection();
        cf.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36");
        cf.setRequestProperty("method", "get");
        cf.connect();

        BufferedReader in  = new BufferedReader(new InputStreamReader(symbolUrl.openStream()));
        String cfCookies = cf.getRequestProperty("cookie");
        setCookie(cfCookies);

        java.net.URL jsonData =  symbolUrl;
        JSONParser parser =  new JSONParser();
        Map CoinRetrieverRequest = (Map)(parser.parse(in));
        JSONArray data = (JSONArray) CoinRetrieverRequest.get("rows");

        for(int i = 0; i < data.size(); i++)
        {
            Map symbolList = (Map)data.get(i);
            symbols.add((String)symbolList.get("code"));
        }*/
    }

    public ArrayList<String> getSymbolList()
    {
        return symbols;
    }

    public void setCookie(String cookie)
    {
        int start = cookie.indexOf("cf_clearance");
        this.cookie = cookie.substring(start, cookie.indexOf(";",start));
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
        hc.setRequestProperty("cookie", "cf_clearance=_5NjJgOrpPZ1MSxXBCcGX474qjOr6wiX.eA5YeBHMHU-1652282256-0-150");
        hc.connect();

        //this is the request to our URL and it returns an text input stream that we can read from
        BufferedReader in = new BufferedReader(new InputStreamReader(hc.getInputStream()));
        JSONParser parser = new JSONParser();
        JSONObject symbolData = (JSONObject)parser.parse(in);
        Map mainSymbolData = (Map)symbolData.get("ticker");
        boolean success =  (boolean) mainSymbolData.get("success");
        CoinRetrieverResponse response;
        if(success)
        {
            String price1 = (String) mainSymbolData.get("price");
            String volume1 = (String) mainSymbolData.get("volume");
            String change1 = (String) mainSymbolData.get("change");

            double price = Double.parseDouble(price1);
            double volume = Double.parseDouble(volume1);
            double change = Double.parseDouble(change1);
            response =  new CoinRetrieverResponse(price, volume, change);
        }
        else
        {
            response =  new CoinRetrieverResponse("No symbol data");
        }

        return response;
    }
}
