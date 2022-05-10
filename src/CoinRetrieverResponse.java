public class CoinRetrieverResponse
{
    private double price;
    private double volume;
    private double change;

    public CoinRetrieverResponse(double price, double volume, double change)
    {
        this.price = price;
        this.volume = volume;
        this.change = change;
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
