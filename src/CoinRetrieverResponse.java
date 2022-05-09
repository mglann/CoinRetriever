public class CoinRetrieverResponse
{
    private double currentPrice;
    private double allVolume;
    private double change;

    public void setCurrentPrice(double currentPrice)
    {
        this.currentPrice = currentPrice;
    }

    public double getCurrentPrice()
    {
        return currentPrice;
    }

    public void setAllVolume(double allVolume)
    {
        this.allVolume = allVolume;
    }

    public double getAllVolume()
    {
        return allVolume;
    }

    public double getChange()
    {
        return change;
    }

    public void setChange(double change)
    {
        this.change = change;
    }
}
