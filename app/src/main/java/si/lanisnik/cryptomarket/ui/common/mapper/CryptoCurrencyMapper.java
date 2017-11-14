package si.lanisnik.cryptomarket.ui.common.mapper;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.data.entities.CurrencyEntity;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CryptoCurrencyMapper implements ViewModelMapper<CurrencyEntity, CryptoCurrency> {

    @Inject
    public CryptoCurrencyMapper() {
    }

    @Override
    public CryptoCurrency mapFromData(CurrencyEntity data) {
        return new CryptoCurrency(
                data.getId(),
                data.getName(),
                data.getSymbol(),
                data.getRank(),
                data.getPriceUsd(),
                data.getPriceBtc(),
                data.getPriceEur(),
                data.getPriceCny(),
                data.getVolume24hUsd(),
                data.getVolume24hEur(),
                data.getVolume24hCny(),
                data.getMarketCapUsd(),
                data.getMarketCapEur(),
                data.getMarketCapCny(),
                data.getAvailableSupply(),
                data.getTotalSupply(),
                data.getPercentChange1h(),
                data.getPercentChange24h(),
                data.getPercentChange7d()
        );
    }
}
