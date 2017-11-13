package si.lanisnik.cryptomarket.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;
import si.lanisnik.cryptomarket.di.scopes.PerApplication;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
@Module
@PerApplication
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

}
