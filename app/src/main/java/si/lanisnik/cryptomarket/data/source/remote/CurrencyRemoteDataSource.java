package si.lanisnik.cryptomarket.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import si.lanisnik.cryptomarket.data.entities.CurrencyEntity;
import si.lanisnik.cryptomarket.data.source.CurrencyRemote;
import si.lanisnik.cryptomarket.data.source.remote.mapper.CurrencyRemoteMapper;
import si.lanisnik.cryptomarket.data.source.remote.model.CurrencyDto;
import si.lanisnik.cryptomarket.data.source.remote.service.CurrencyService;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyRemoteDataSource implements CurrencyRemote {

    private CurrencyService service;
    private CurrencyRemoteMapper mapper;

    @Inject
    public CurrencyRemoteDataSource(CurrencyService service, CurrencyRemoteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public Single<List<CurrencyEntity>> getTopCurrencies(int limit, String currency) {
        return service.getTopCurrencies(limit, currency)
                .map(currencies -> {
                    if (currencies != null) {
                        List<CurrencyEntity> currencyEntities = new ArrayList<>(currencies.size());
                        for (CurrencyDto dto : currencies) {
                            currencyEntities.add(mapper.mapFromRemote(dto));
                        }
                        return currencyEntities;
                    }
                    return null;
                });
    }

    @Override
    public Single<CurrencyEntity> getCurrency(String id, String currency) {
        return service.getCurrency(id, currency)
                .map(currencies -> {
                    if (currencies != null && !currencies.isEmpty()) {
                        return mapper.mapFromRemote(currencies.get(0));
                    }
                    return null;
                });
    }
}
