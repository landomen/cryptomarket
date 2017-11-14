package si.lanisnik.cryptomarket.data.source.local;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.data.DataConstants;
import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.data.source.CurrencyLocal;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyLocalDataSource implements CurrencyLocal {

    private static final String PREFS_FILE = "CryptoMarketPreferences";
    private static final String PREF_KEY_LIMIT = "limit";
    private static final String PREF_KEY_CURRENCY = "selectedFiatCurrency";

    private SharedPreferences sharedPreferences;

    @Inject
    CurrencyLocalDataSource(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
    }

    @Override
    public void saveLimit(int limit) {
        sharedPreferences.edit().putInt(PREF_KEY_LIMIT, limit).apply();
    }

    @Override
    public int getLimit() {
        return sharedPreferences.getInt(PREF_KEY_LIMIT, DataConstants.DEFAULT_LIMIT);
    }

    @Override
    public void saveSelectedFiatCurrency(FiatCurrencyType fiatCurrencyType) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENCY, fiatCurrencyType.name()).apply();
    }

    @Override
    public FiatCurrencyType getSelectedFiatCurrency() {
        String selectedCurrency = sharedPreferences.getString(PREF_KEY_CURRENCY, null);
        if (selectedCurrency != null) {
            return FiatCurrencyType.valueOf(selectedCurrency);
        }
        return DataConstants.DEFAULT_FIAT_CURRENCY;
    }
}
