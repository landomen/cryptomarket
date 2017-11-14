package si.lanisnik.cryptomarket.ui.cryptodetails.module;

import dagger.Binds;
import dagger.Module;
import si.lanisnik.cryptomarket.di.scopes.PerActivity;
import si.lanisnik.cryptomarket.ui.cryptodetails.CryptoDetailsContract;
import si.lanisnik.cryptomarket.ui.cryptodetails.CryptoDetailsPresenter;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
@Module
public abstract class CryptoDetailsModule {

    @PerActivity
    @Binds
    abstract CryptoDetailsContract.Presenter cryptoDetailsPresenter(CryptoDetailsPresenter presenter);
}
