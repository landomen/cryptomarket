package si.lanisnik.cryptomarket.data.source;

import java.util.List;

import io.reactivex.Single;
import si.lanisnik.cryptomarket.data.entities.CurrencyEntity;
import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public interface CurrencyRepository {

    /**
     * Retrieves the top currencies using the saved parameter settings.
     *
     * @return
     */
    Single<List<CurrencyEntity>> getTopCurrencies();

    /**
     * Retrieves details for this currency.
     *
     * @param currencyId
     * @return
     */
    Single<CurrencyEntity> getCurrencyDetails(String currencyId);

    /**
     * Saves the new result limit value.
     *
     * @param limit
     */
    void saveResultLimit(int limit);

    /**
     * @return Currently set result size limit
     */
    int getResultLimit();

    /**
     * Saves the selected fiat currency as new default.
     *
     * @param fiatCurrencyType
     */
    void saveSelectedFiatCurrency(FiatCurrencyType fiatCurrencyType);

    /**
     * @return Currently selected fiat currency
     */
    FiatCurrencyType getSelectedFiatCurrency();

}
