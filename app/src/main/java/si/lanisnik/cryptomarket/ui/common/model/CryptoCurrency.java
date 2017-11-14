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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public String getPriceEur() {
        return priceEur;
    }

    public void setPriceEur(String priceEur) {
        this.priceEur = priceEur;
    }

    public String getPriceCny() {
        return priceCny;
    }

    public void setPriceCny(String priceCny) {
        this.priceCny = priceCny;
    }

    public String getVolume24hUsd() {
        return volume24hUsd;
    }

    public void setVolume24hUsd(String volume24hUsd) {
        this.volume24hUsd = volume24hUsd;
    }

    public String getVolume24hEur() {
        return volume24hEur;
    }

    public void setVolume24hEur(String volume24hEur) {
        this.volume24hEur = volume24hEur;
    }

    public String getVolume24hCny() {
        return volume24hCny;
    }

    public void setVolume24hCny(String volume24hCny) {
        this.volume24hCny = volume24hCny;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public String getMarketCapEur() {
        return marketCapEur;
    }

    public void setMarketCapEur(String marketCapEur) {
        this.marketCapEur = marketCapEur;
    }

    public String getMarketCapCny() {
        return marketCapCny;
    }

    public void setMarketCapCny(String marketCapCny) {
        this.marketCapCny = marketCapCny;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }
}
