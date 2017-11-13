package si.lanisnik.cryptomarket.data.remote;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import si.lanisnik.cryptomarket.BuildConfig;
import si.lanisnik.cryptomarket.data.remote.service.CurrencyService;
import si.lanisnik.cryptomarket.di.scopes.PerApplication;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
@Module
public class NetModule {

    @Provides
    @PerApplication
    CurrencyService provideCurrencyService(Retrofit retrofit) {
        return retrofit.create(CurrencyService.class);
    }

    @Provides
    @PerApplication
    Retrofit provideRetrofit(@Named("serverBaseUrl") String serverUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(serverUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @PerApplication
    @Named("serverBaseUrl")
    String provideServerBaseUrl() {
        return BuildConfig.SERVER_BASE_URL;
    }

    @Provides
    @PerApplication
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @PerApplication
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

}
