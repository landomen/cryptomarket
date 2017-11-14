package si.lanisnik.cryptomarket.data.source;

import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public interface CurrencyLocal {

    void saveLimit(int limit);

    int getLimit();

    void saveSelectedFiatCurrency(FiatCurrencyType fiatCurrencyType);

    FiatCurrencyType getSelectedFiatCurrency();

}
