package Model;

import com.google.gson.annotations.SerializedName;

public class CoinMarketData
{
    private String symbol;
    private String name;
    private CryptoImages image;
    @SerializedName("market_data")
    MarketData marketData;

    public String getSymbol()
    {
        return symbol;
    }

    public String getName()
    {
        return name;
    }

    public CryptoImages getImage()
    {
        return image;
    }

    public MarketData getMarketData()
    {
        return marketData;
    }
}
