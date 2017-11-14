package si.lanisnik.cryptomarket.ui.common.util;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.di.scopes.PerApplication;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;

/**
 * Helper class for selecting the correct fiat value.
 * <p>
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
@PerApplication
public class CurrencyConverter {

    @Inject
    public CurrencyConverter() {

    }

    public String getPrice(CryptoCurrency currency, FiatCurrencyType fiatCurrency) {
        switch (fiatCurrency) {
            case CNY:
                return currency.getPriceCny();
            case EUR:
                return currency.getPriceEur();
            case USD:
            default:
                return currency.getPriceUsd();
        }
    }

    public String getVolume(CryptoCurrency currency, FiatCurrencyType fiatCurrency) {
        switch (fiatCurrency) {
            case CNY:
                return currency.getVolume24hCny();
            case EUR:
                return currency.getVolume24hEur();
            case USD:
            default:
                return currency.getVolume24hUsd();
        }
    }

    public String getMarketCap(CryptoCurrency currency, FiatCurrencyType fiatCurrency) {
        switch (fiatCurrency) {
            case CNY:
                return currency.getMarketCapCny();
            case EUR:
                return currency.getMarketCapEur();
            case USD:
            default:
                return currency.getMarketCapUsd();
        }
    }
}
