package si.lanisnik.cryptomarket.data.source.remote.mapper;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.data.entities.CurrencyEntity;
import si.lanisnik.cryptomarket.data.source.remote.model.CurrencyDto;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyRemoteMapper implements RemoteModelMapper<CurrencyEntity, CurrencyDto> {

    @Inject
    public CurrencyRemoteMapper() {
    }

    @Override
    public CurrencyEntity mapFromRemote(CurrencyDto remote) {
        return new CurrencyEntity(remote.getId(),
                remote.getName(),
                remote.getSymbol(),
                remote.getRank(),
                remote.getPriceUsd(),
                remote.getPriceBtc(),
                remote.getPriceEur(),
                remote.getPriceCny(),
                remote.getVolume24hUsd(),
                remote.getVolume24hEur(),
                remote.getVolume24hCny(),
                remote.getMarketCapUsd(),
                remote.getMarketCapEur(),
                remote.getMarketCapCny(),
                remote.getAvailableSupply(),
                remote.getTotalSupply(),
                remote.getPercentChange1h(),
                remote.getPercentChange24h(),
                remote.getPercentChange7d());
    }
}
