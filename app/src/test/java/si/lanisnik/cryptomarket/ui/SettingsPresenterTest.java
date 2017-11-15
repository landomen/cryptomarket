package si.lanisnik.cryptomarket.ui;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.data.source.CurrencyRepository;
import si.lanisnik.cryptomarket.ui.settings.SettingsContract;
import si.lanisnik.cryptomarket.ui.settings.SettingsPresenter;
import si.lanisnik.cryptomarket.ui.settings.model.SettingsResult;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public class SettingsPresenterTest {

    private static final int DEFAULT_LIMIT = 100;
    private static final FiatCurrencyType DEFAULT_CURRENCY = FiatCurrencyType.USD;

    @Mock
    private SettingsContract.View view;
    @Mock
    private CurrencyRepository repository;
    private SettingsPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        when(repository.getResultLimit()).thenReturn(DEFAULT_LIMIT);
        when(repository.getSelectedFiatCurrency()).thenReturn(DEFAULT_CURRENCY);

        presenter = new SettingsPresenter(repository);
        presenter.setView(view);
    }

    @Test
    public void testCurrencyAdapterValues() {
        String[] values = {"CNY", "EUR", "USD"};

        presenter.initialize();
        verify(view, times(1)).setupCurrencySpinner(values);
        verify(view).setupCurrencySpinner(values);
    }

    @Test
    public void testInitialValues() {
        presenter.initialize();
        verify(view).setLimitValue(DEFAULT_LIMIT);
        verify(view).setCurrencySpinnerPosition(DEFAULT_CURRENCY.ordinal());
    }

    @Test
    public void testSavingSameValuesOnExit() {
        // no settings were changed
        presenter.onBackPressed(DEFAULT_CURRENCY.ordinal(), String.valueOf(DEFAULT_LIMIT));

        // check that result indicates no settings were changed
        ArgumentCaptor<SettingsResult> settingsResultCaptor = ArgumentCaptor.forClass(SettingsResult.class);
        verify(view, times(1)).closeActivityWithResult(settingsResultCaptor.capture());
        assertFalse(settingsResultCaptor.getValue().isCurrencyChanged());
        assertFalse(settingsResultCaptor.getValue().isLimitChanged());
    }

    @Test
    public void testSavingNewLimitOnExit() {
        // only limit was changed
        presenter.onBackPressed(DEFAULT_CURRENCY.ordinal(), String.valueOf("50"));

        // check repository calls
        verify(repository, times(1)).getResultLimit();
        verify(repository, times(1)).saveResultLimit(50);
        verify(repository, times(1)).getSelectedFiatCurrency();
        verify(repository, times(0)).saveSelectedFiatCurrency(DEFAULT_CURRENCY);

        // success message has to be displayed
        verify(view).showSaveMessage();

        // check that only limit is marked as changed in the result
        ArgumentCaptor<SettingsResult> settingsResultCaptor = ArgumentCaptor.forClass(SettingsResult.class);
        verify(view, times(1)).closeActivityWithResult(settingsResultCaptor.capture());
        assertFalse(settingsResultCaptor.getValue().isCurrencyChanged());
        assertTrue(settingsResultCaptor.getValue().isLimitChanged());
    }

    @Test
    public void testSavingNewCurrencyOnExit() {
        FiatCurrencyType newCurrency = FiatCurrencyType.CNY;

        // only currency was changed
        presenter.onBackPressed(newCurrency.ordinal(), String.valueOf(DEFAULT_LIMIT));

        // check repository calls
        verify(repository, times(1)).getResultLimit();
        verify(repository, times(0)).saveResultLimit(DEFAULT_LIMIT);
        verify(repository, times(1)).getSelectedFiatCurrency();
        verify(repository, times(1)).saveSelectedFiatCurrency(newCurrency);

        // success message has to be displayed
        verify(view).showSaveMessage();

        // check that only currency is marked as changed in the result
        ArgumentCaptor<SettingsResult> settingsResultCaptor = ArgumentCaptor.forClass(SettingsResult.class);
        verify(view, times(1)).closeActivityWithResult(settingsResultCaptor.capture());
        assertTrue(settingsResultCaptor.getValue().isCurrencyChanged());
        assertFalse(settingsResultCaptor.getValue().isLimitChanged());
    }

    @Test
    public void testSavingLimitAndCurrencyOnExit() {
        FiatCurrencyType newCurrency = FiatCurrencyType.CNY;
        int newLimit = 20;

        presenter.onBackPressed(newCurrency.ordinal(), String.valueOf(newLimit));

        // check repository calls
        verify(repository, times(1)).getResultLimit();
        verify(repository, times(1)).getSelectedFiatCurrency();
        verify(repository, times(1)).saveResultLimit(newLimit);
        verify(repository, times(1)).saveSelectedFiatCurrency(newCurrency);

        // success message has to be displayed
        verify(view).showSaveMessage();

        // check that both limit and currency are marked as changed
        ArgumentCaptor<SettingsResult> settingsResultCaptor = ArgumentCaptor.forClass(SettingsResult.class);
        verify(view, times(1)).closeActivityWithResult(settingsResultCaptor.capture());
        assertTrue(settingsResultCaptor.getValue().isCurrencyChanged());
        assertTrue(settingsResultCaptor.getValue().isLimitChanged());
    }

}
