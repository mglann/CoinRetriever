//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;
import java.net.*;
import java.util.Map;
import java.io.*;

public class CoinRetrieverRequest
{
    private String symbol;

    public void setTicker()
    {
        this.symbol = symbol;
    }

    public String getTicker()
    {
        return symbol;
    }

    public boolean validateSymbol(String Symbol)
    {
        return true;
    }
}
