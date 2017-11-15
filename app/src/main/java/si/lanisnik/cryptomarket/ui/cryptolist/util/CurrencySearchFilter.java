package si.lanisnik.cryptomarket.ui.cryptolist.util;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencySearchFilter {

    @Inject
    public CurrencySearchFilter() {
    }

    public List<CryptoCurrency> filterCurrencies(List<CryptoCurrency> currencies, String query) {
        List<CryptoCurrency> filteredCurrencies = new ArrayList<>();
        if (query.isEmpty()) {
            filteredCurrencies.addAll(currencies);
        } else {
            for (CryptoCurrency currency : currencies) {
                if (isPresentIn(currency.getName(), query) || isPresentIn(currency.getSymbol(), query)) {
                    filteredCurrencies.add(currency);
                }
            }
        }
        return filteredCurrencies;
    }

    private boolean isPresentIn(@Nullable String field, String query) {
        return field != null && field.toLowerCase().contains(query.toLowerCase());
    }
}
