package si.lanisnik.cryptomarket.ui.settings;

import si.lanisnik.cryptomarket.ui.common.BasePresenter;
import si.lanisnik.cryptomarket.ui.common.BaseView;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public interface SettingsContract {

    interface View extends BaseView {
        void setupToolbar();

        void setupCurrencySpinner(String[] currencies);
    }

    interface Presenter extends BasePresenter<View> {
        void initialize();

        void onCurrencySelected(int position);

        void onBackPressed();
    }
}
