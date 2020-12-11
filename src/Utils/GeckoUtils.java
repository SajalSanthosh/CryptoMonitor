package Utils;

import Model.CoinList;
import Model.CoinMarketChart;
import Model.CoinMarketData;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;

public class GeckoUtils
{
    public static CoinList[] getAllCoins()
    {
        CoinList[] coinLists = null;
        String apiResponse = HttpUtils.fetchData("https://api.coingecko.com/api/v3/coins/list");

        try (JsonReader jsonReader = new JsonReader(new StringReader(apiResponse));)
        {
            Gson gson = new Gson();
            coinLists = gson.fromJson(jsonReader, CoinList[].class);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //

        return coinLists;
    }

    public static CoinMarketData getCoinMarketData(String coinId)
    {
        CoinMarketData coinMarketData = null;
        String apiResponse = HttpUtils.fetchData("https://api.coingecko.com/api/v3/coins/" + coinId + "?localization=false&tickers=false&market_data=true&community_data=false&developer_data=false&sparkline=false");

        try (JsonReader jsonReader = new JsonReader(new StringReader(apiResponse));)
        {
            Gson gson = new Gson();
            coinMarketData = gson.fromJson(jsonReader, CoinMarketData.class);
            System.out.println();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //

        return coinMarketData;
    }


    public static CoinMarketChart getCoinMarketChart(String coinId)
    {
        CoinMarketChart coinMarketChart = null;
        String apiResponse = HttpUtils.fetchData("https://api.coingecko.com/api/v3/coins/" + coinId + "/market_chart?vs_currency=usd&days=30&interval=daily");

        try (JsonReader jsonReader = new JsonReader(new StringReader(apiResponse));)
        {
            Gson gson = new Gson();
            coinMarketChart = gson.fromJson(jsonReader, CoinMarketChart.class);
            System.out.println();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return coinMarketChart;
    }
}
