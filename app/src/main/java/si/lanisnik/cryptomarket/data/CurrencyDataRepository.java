package si.lanisnik.cryptomarket.data;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import si.lanisnik.cryptomarket.data.entities.CurrencyEntity;
import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.data.source.CurrencyLocal;
import si.lanisnik.cryptomarket.data.source.CurrencyRemote;
import si.lanisnik.cryptomarket.data.source.CurrencyRepository;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyDataRepository implements CurrencyRepository {

    private CurrencyLocal localDataSource;
    private CurrencyRemote remoteDataSource;
    private int currentLimit;
    private FiatCurrencyType currentFiatCurrency;

    @Inject
    public CurrencyDataRepository(CurrencyLocal localDataSource, CurrencyRemote remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        currentLimit = getResultLimit();
        currentFiatCurrency = getSelectedFiatCurrency();
    }

    @Override
    public Single<List<CurrencyEntity>> getTopCurrencies() {
        return remoteDataSource.getTopCurrencies(currentLimit, currentFiatCurrency.name());
    }

    @Override
    public Single<CurrencyEntity> getCurrencyDetails(String currencyId) {
        return remoteDataSource.getCurrency(currencyId, currentFiatCurrency.name());
    }

    @Override
    public void saveResultLimit(int limit) {
        localDataSource.saveLimit(limit);
        currentLimit = limit;
    }

    @Override
    public int getResultLimit() {
        return localDataSource.getLimit();
    }

    @Override
    public void saveSelectedFiatCurrency(FiatCurrencyType fiatCurrencyType) {
        localDataSource.saveSelectedFiatCurrency(fiatCurrencyType);
        currentFiatCurrency = fiatCurrencyType;
    }

    @Override
    public FiatCurrencyType getSelectedFiatCurrency() {
        return localDataSource.getSelectedFiatCurrency();
    }
}
