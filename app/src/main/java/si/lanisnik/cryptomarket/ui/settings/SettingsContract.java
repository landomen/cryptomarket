package si.lanisnik.cryptomarket.ui.settings;

import si.lanisnik.cryptomarket.ui.common.BasePresenter;
import si.lanisnik.cryptomarket.ui.common.BaseView;
import si.lanisnik.cryptomarket.ui.settings.model.SettingsResult;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public interface SettingsContract {

    interface View extends BaseView {
        void setupToolbar();

        void setupCurrencySpinner(String[] currencies);

        void setCurrencySpinnerPosition(int position);

        void setLimitValue(int limit);

        void showSaveMessage();

        void closeActivityWithResult(SettingsResult result);
    }

    interface Presenter extends BasePresenter<View> {
        void initialize();

        void onBackPressed(int selectedCurrencyPosition, String limit);
    }
}
