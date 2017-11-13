package si.lanisnik.cryptomarket.data.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyDto {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("rank")
    private String rank;

    @SerializedName("price_usd")
    private String priceUsd;

    @SerializedName("price_btc")
    private String priceBtc;

    @SerializedName("price_eur")
    private String priceEur;

    @SerializedName("price_cny")
    private String priceCny;

    @SerializedName("24h_volume_usd")
    private String volume24hUsd;

    @SerializedName("24h_volume_eur")
    private String volume24hEur;

    @SerializedName("24h_volume_cny")
    private String volume24hCny;

    @SerializedName("market_cap_usd")
    private String marketCapUsd;

    @SerializedName("market_cap_eur")
    private String marketCapEur;

    @SerializedName("market_cap_cny")
    private String marketCapCny;

    @SerializedName("available_supply")
    private String availableSupply;

    @SerializedName("total_supply")
    private String totalSupply;

    @SerializedName("percent_change_1h")
    private String percentChange1h;

    @SerializedName("percent_change_24h")
    private String percentChange24h;

    @SerializedName("percent_change_7d")
    private String percentChange7d;

    @SerializedName("last_updated")
    private String lastUpdated;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRank() {
        return rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public String getPriceEur() {
        return priceEur;
    }

    public String getPriceCny() {
        return priceCny;
    }

    public String getVolume24hUsd() {
        return volume24hUsd;
    }

    public String getVolume24hEur() {
        return volume24hEur;
    }

    public String getVolume24hCny() {
        return volume24hCny;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public String getMarketCapEur() {
        return marketCapEur;
    }

    public String getMarketCapCny() {
        return marketCapCny;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
