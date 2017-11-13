package si.lanisnik.cryptomarket.data.remote.service;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import si.lanisnik.cryptomarket.data.remote.model.CurrencyDto;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public interface CurrencyService {

    @GET("ticker/")
    Single<List<CurrencyDto>> getTopCurrencies(@Query("limit") int limit,
                                               @Query("convert") String currency);

    @GET("ticker/{id}/")
    Single<List<CurrencyDto>> getCurrency(@Path("id") String id,
                                    @Query("convert") String currency);

}
