package si.lanisnik.cryptomarket.data.entities;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyEntity {
    private String id;
    private String name;
    private String symbol;
    private String rank;

    private String priceUsd;
    private String priceBtc;
    private String priceEur;
    private String priceCny;

    private String volume24hUsd;
    private String volume24hEur;
    private String volume24hCny;

    private String marketCapUsd;
    private String marketCapEur;
    private String marketCapCny;

    private String availableSupply;
    private String totalSupply;
    private String percentChange1h;
    private String percentChange24h;
    private String percentChange7d;
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
