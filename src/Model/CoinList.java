package Model;

public class CoinList
{
    private String id;
    private String symbol;
    private String name;

    public CoinList(String id, String symbol, String name)
    {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public String getName()
    {
        return name;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
