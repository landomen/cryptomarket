package si.lanisnik.cryptomarket.ui.cryptolist.module;

import dagger.Binds;
import dagger.Module;
import si.lanisnik.cryptomarket.di.scopes.PerActivity;
import si.lanisnik.cryptomarket.ui.cryptolist.CryptoListContract;
import si.lanisnik.cryptomarket.ui.cryptolist.CryptoListPresenter;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
@Module
public abstract class CryptoListModule {

    @PerActivity
    @Binds
    abstract CryptoListContract.Presenter cryptoListPresenter(CryptoListPresenter presenter);

}
