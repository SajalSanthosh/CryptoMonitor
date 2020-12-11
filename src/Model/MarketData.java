package Model;


import com.google.gson.annotations.SerializedName;

public class MarketData
{
    @SerializedName("current_price")
    CurrencyList currentPrice;
    @SerializedName("high_24h")
    CurrencyList high24h;
    @SerializedName("low_24h")
    CurrencyList low24h;
    @SerializedName("price_change_24h")
    String priceChange24h;
    @SerializedName("price_change_percentage_24h")
    String priceChangePercentage24h;
    @SerializedName("price_change_percentage_7d")
    String priceChangePercentage7d;
    @SerializedName("price_change_percentage_14d")
    String priceChangePercentage14d;
    @SerializedName("price_change_percentage_30d")
    String priceChangePercentage30d;
    @SerializedName("price_change_percentage_60d")
    String priceChangePercentage60d;
    @SerializedName("price_change_percentage_200d")
    String priceChangePercentage200d;
    @SerializedName("price_change_percentage_1y")
    String priceChangePercentage1y;

    public CurrencyList getCurrentPrice()
    {
        return currentPrice;
    }

    public CurrencyList getHigh24h()
    {
        return high24h;
    }

    public CurrencyList getLow24h()
    {
        return low24h;
    }

    public String getPriceChange24h()
    {
        return priceChange24h;
    }

    public String getPriceChangePercentage24h()
    {
        return priceChangePercentage24h;
    }

    public String getPriceChangePercentage7d()
    {
        return priceChangePercentage7d;
    }

    public String getPriceChangePercentage14d()
    {
        return priceChangePercentage14d;
    }

    public String getPriceChangePercentage30d()
    {
        return priceChangePercentage30d;
    }

    public String getPriceChangePercentage60d()
    {
        return priceChangePercentage60d;
    }

    public String getPriceChangePercentage200d()
    {
        return priceChangePercentage200d;
    }

    public String getPriceChangePercentage1y()
    {
        return priceChangePercentage1y;
    }
}