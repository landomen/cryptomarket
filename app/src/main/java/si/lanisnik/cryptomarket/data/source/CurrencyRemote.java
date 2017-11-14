package si.lanisnik.cryptomarket.data.source;

import java.util.List;

import io.reactivex.Single;
import si.lanisnik.cryptomarket.data.entities.CurrencyEntity;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public interface CurrencyRemote {

    Single<List<CurrencyEntity>> getTopCurrencies(int limit, String currency);

    Single<CurrencyEntity> getCurrency(String id, String currency);

}
