public class CoinRetrieverResponse
{
    private double currentPrice;
    private double allVolume;
    private String supportedMarkets;

    public CoinRetrieverResponse(double currentPrice)
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
}
