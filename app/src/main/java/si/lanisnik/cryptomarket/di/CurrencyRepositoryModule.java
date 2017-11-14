package si.lanisnik.cryptomarket.di;

import dagger.Binds;
import dagger.Module;
import si.lanisnik.cryptomarket.data.CurrencyDataRepository;
import si.lanisnik.cryptomarket.data.source.CurrencyLocal;
import si.lanisnik.cryptomarket.data.source.CurrencyRemote;
import si.lanisnik.cryptomarket.data.source.CurrencyRepository;
import si.lanisnik.cryptomarket.data.source.local.CurrencyLocalDataSource;
import si.lanisnik.cryptomarket.data.source.remote.CurrencyRemoteDataSource;
import si.lanisnik.cryptomarket.di.scopes.PerApplication;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
@Module
public abstract class CurrencyRepositoryModule {

    @PerApplication
    @Binds
    abstract CurrencyLocal bindLocal(CurrencyLocalDataSource localDataSource);

    @PerApplication
    @Binds
    abstract CurrencyRemote bindRemote(CurrencyRemoteDataSource remoteDataSource);

    @PerApplication
    @Binds
    abstract CurrencyRepository bindRepository(CurrencyDataRepository dataRepository);

}
