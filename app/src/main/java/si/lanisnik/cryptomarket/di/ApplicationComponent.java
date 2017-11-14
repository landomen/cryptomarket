package si.lanisnik.cryptomarket.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import si.lanisnik.cryptomarket.data.source.remote.NetModule;
import si.lanisnik.cryptomarket.di.scopes.PerApplication;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
@PerApplication
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        NetModule.class,
        CurrencyRepositoryModule.class,
        AndroidInjectionModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        ApplicationComponent.Builder application(Application application);

        ApplicationComponent build();
    }

    @Override
    void inject(DaggerApplication instance);
}
