package Utils;

import Model.CoinList;
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
            System.out.println();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //

        return coinLists;
    }
}
