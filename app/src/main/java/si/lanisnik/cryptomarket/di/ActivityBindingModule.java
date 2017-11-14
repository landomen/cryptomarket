package si.lanisnik.cryptomarket.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import si.lanisnik.cryptomarket.di.scopes.PerActivity;
import si.lanisnik.cryptomarket.ui.cryptodetails.CryptoDetailsActivity;
import si.lanisnik.cryptomarket.ui.cryptodetails.module.CryptoDetailsModule;
import si.lanisnik.cryptomarket.ui.cryptolist.CryptoListActivity;
import si.lanisnik.cryptomarket.ui.cryptolist.module.CryptoListModule;
import si.lanisnik.cryptomarket.ui.settings.SettingsActivity;
import si.lanisnik.cryptomarket.ui.settings.module.SettingsModule;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
@Module
public abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = CryptoListModule.class)
    abstract CryptoListActivity cryptoListActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = CryptoDetailsModule.class)
    abstract CryptoDetailsActivity cryptoDetailsActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = SettingsModule.class)
    abstract SettingsActivity settingsActivity();

}
