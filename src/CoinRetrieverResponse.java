public class CoinRetrieverResponse
{
    private double price;
    private double volume;
    private double change;
    private String error;

    public CoinRetrieverResponse(String error)
    {
        this.error = error;
    }

    public CoinRetrieverResponse(double price, double volume, double change)
    {
        this.price = price;
        this.volume = volume;
        this.change = change;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    public double getPrice()
    {
        return price;
    }

    public double getVolume()
    {
        return volume;
    }

    public double getChange()
    {
        return change;
    }
}
