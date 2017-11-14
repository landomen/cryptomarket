package si.lanisnik.cryptomarket.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import si.lanisnik.cryptomarket.di.scopes.PerActivity;
import si.lanisnik.cryptomarket.ui.cryptolist.CryptoListActivity;
import si.lanisnik.cryptomarket.ui.cryptolist.module.CryptoListModule;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
@Module
public abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = CryptoListModule.class)
    abstract CryptoListActivity cryptoListActivity();

}
