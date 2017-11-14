package si.lanisnik.cryptomarket.ui.settings.module;

import dagger.Binds;
import dagger.Module;
import si.lanisnik.cryptomarket.di.scopes.PerActivity;
import si.lanisnik.cryptomarket.ui.settings.SettingsContract;
import si.lanisnik.cryptomarket.ui.settings.SettingsPresenter;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
@Module
public abstract class SettingsModule {

    @PerActivity
    @Binds
    abstract SettingsContract.Presenter settingsPresenter(SettingsPresenter presenter);

}
