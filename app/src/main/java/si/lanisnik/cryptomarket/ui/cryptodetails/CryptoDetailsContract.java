package si.lanisnik.cryptomarket.ui.cryptodetails;

import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.ui.common.BasePresenter;
import si.lanisnik.cryptomarket.ui.common.BaseView;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.settings.model.SettingsResult;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public interface CryptoDetailsContract {

    interface View extends BaseView {
        void setupToolbar(String title);

        void setupRecyclerView();

        void setupSwipeLayout();

        void buildAndShowCurrencyDetails(CryptoCurrency currency, FiatCurrencyType fiatCurrencyType);

        void showLoadingError();

        void showLoading();

        void hideLoading();

        void openSettings();

        void closeActivityWithResult(SettingsResult result);

        void closeActivity();
    }

    interface Presenter extends BasePresenter<CryptoDetailsContract.View> {
        void initialize(CryptoCurrency currency);

        void update();

        void onSettingsClicked();

        void onSettingsResult(SettingsResult result);

        void onBackPressed();
    }

}
