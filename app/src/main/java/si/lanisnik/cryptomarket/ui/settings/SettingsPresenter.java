package si.lanisnik.cryptomarket.ui.settings;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.data.source.CurrencyRepository;
import si.lanisnik.cryptomarket.ui.settings.model.SettingsResult;
import si.lanisnik.cryptomarket.util.GeneralUtil;

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
        view.setupCurrencySpinner(createCurrencyAdapterValues());
        view.setCurrencySpinnerPosition(repository.getSelectedFiatCurrency().ordinal());
        view.setLimitValue(repository.getResultLimit());
    }

    @Override
    public void onBackPressed(int selectedCurrencyPosition, String limit) {
        final boolean currencyChanged = saveFiatCurrencyIfNeeded(selectedCurrencyPosition);
        final boolean limitChanged = saveLimitIfNeeded(limit);
        if (currencyChanged || limitChanged) {
            view.showSaveMessage();
        }
        view.closeActivityWithResult(new SettingsResult(currencyChanged, limitChanged));
    }

    @Override
    public void destroy() {
        view = null;
    }

    /**
     * Creates an array of {@link FiatCurrencyType} enum names
     * to be used as spinner adapter contents.
     *
     * @return
     */
    private String[] createCurrencyAdapterValues() {
        FiatCurrencyType[] enumValues = FiatCurrencyType.values();
        String[] stringValues = new String[enumValues.length];
        for (int i = 0; i < enumValues.length; i++) {
            stringValues[i] = enumValues[i].name();
        }
        return stringValues;
    }

    /**
     * Saves the user selected fiat currency as default if needed (has changed).
     *
     * @param selectedCurrencyPosition
     * @return True if saved, false if currency hasn't changed
     */
    private boolean saveFiatCurrencyIfNeeded(int selectedCurrencyPosition) {
        final FiatCurrencyType selectedFiatCurrency = FiatCurrencyType.values()[selectedCurrencyPosition];
        if (repository.getSelectedFiatCurrency() != selectedFiatCurrency) {
            repository.saveSelectedFiatCurrency(selectedFiatCurrency);
            return true;
        }
        return false;
    }

    /**
     * Saves the user inputted limit as default if needed (has changed).
     *
     * @param limit
     * @return True if saved, false if limit hasn't changed
     */
    private boolean saveLimitIfNeeded(String limit) {
        Integer newLimit = GeneralUtil.safeParseInt(limit.trim());
        if (newLimit != null && repository.getResultLimit() != newLimit) {
            repository.saveResultLimit(newLimit);
            return true;
        }
        return false;
    }
}
