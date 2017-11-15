package si.lanisnik.cryptomarket.ui.cryptolist;

import java.util.List;

import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.ui.common.BasePresenter;
import si.lanisnik.cryptomarket.ui.common.BaseView;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.common.util.CurrencyConverter;
import si.lanisnik.cryptomarket.ui.settings.model.SettingsResult;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public interface CryptoListContract {

    interface View extends BaseView {
        void setupToolbar();

        void setupRecyclerView();

        void setupAdapter(FiatCurrencyType fiatCurrency, CurrencyConverter converter);

        void setupSwipeLayout();

        void showCurrencies(List<CryptoCurrency> currencies, FiatCurrencyType fiatCurrencyType);

        void showLoadingError();

        void showLoading();

        void hideLoading();

        void openSettings();
    }

    interface Presenter extends BasePresenter<View> {
        void initialize();

        void update();

        void onSettingsClicked();

        void onSettingsResult(SettingsResult result);
    }
}
