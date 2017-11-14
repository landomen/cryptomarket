package si.lanisnik.cryptomarket.ui.common.model;

import org.parceler.Parcel;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
@Parcel(Parcel.Serialization.BEAN)
public class CryptoCurrency {
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

    // required empty constructor
    public CryptoCurrency() {
    }

    public CryptoCurrency(String id, String name, String symbol, String rank, String priceUsd, String priceBtc, String priceEur, String priceCny, String volume24hUsd, String volume24hEur, String volume24hCny, String marketCapUsd, String marketCapEur, String marketCapCny, String availableSupply, String totalSupply, String percentChange1h, String percentChange24h, String percentChange7d) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.priceUsd = priceUsd;
        this.priceBtc = priceBtc;
        this.priceEur = priceEur;
        this.priceCny = priceCny;
        this.volume24hUsd = volume24hUsd;
        this.volume24hEur = volume24hEur;
        this.volume24hCny = volume24hCny;
        this.marketCapUsd = marketCapUsd;
        this.marketCapEur = marketCapEur;
        this.marketCapCny = marketCapCny;
        this.availableSupply = availableSupply;
        this.totalSupply = totalSupply;
        this.percentChange1h = percentChange1h;
        this.percentChange24h = percentChange24h;
        this.percentChange7d = percentChange7d;
    }

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
}
