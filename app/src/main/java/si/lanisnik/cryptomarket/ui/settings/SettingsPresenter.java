package si.lanisnik.cryptomarket.ui.settings;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.data.source.CurrencyRepository;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public class SettingsPresenter implements SettingsContract.Presenter {

    private CurrencyRepository repository;
    private SettingsContract.View view;

    @Inject
    public SettingsPresenter(CurrencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void setView(SettingsContract.View view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        view.setupToolbar();
        view.setupCurrencySpinner(new String[]{"CNY", "EUR", "USD"});
    }

    @Override
    public void onCurrencySelected(int position) {
        // TODO
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void destroy() {
        view = null;
    }
}
