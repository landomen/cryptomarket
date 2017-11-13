package si.lanisnik.cryptomarket;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import si.lanisnik.cryptomarket.di.ApplicationComponent;
import si.lanisnik.cryptomarket.di.DaggerApplicationComponent;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CryptoMarketApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder().application(this).build();
        applicationComponent.inject(this);
        return applicationComponent;
    }
}
