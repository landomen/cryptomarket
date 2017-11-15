package si.lanisnik.cryptomarket.ui.cryptodetails;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import si.lanisnik.cryptomarket.data.source.CurrencyRepository;
import si.lanisnik.cryptomarket.ui.common.mapper.CryptoCurrencyMapper;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.settings.model.SettingsResult;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CryptoDetailsPresenter implements CryptoDetailsContract.Presenter {

    private CurrencyRepository repository;
    private CryptoDetailsContract.View view;
    private Disposable disposable;
    private CryptoCurrency currency;
    private CryptoCurrencyMapper mapper;
    private SettingsResult settingsResult;

    @Inject
    public CryptoDetailsPresenter(CurrencyRepository repository, CryptoCurrencyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void setView(CryptoDetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void initialize(CryptoCurrency currency) {
        this.currency = currency;
        view.setupToolbar(currency.getName());
        view.setupSwipeLayout();
        view.setupRecyclerView();
        view.buildAndShowCurrencyDetails(currency, repository.getSelectedFiatCurrency());
    }

    @Override
    public void update() {
        fetchDetails();
    }

    @Override
    public void onSettingsClicked() {
        view.openSettings();
    }

    @Override
    public void onSettingsResult(SettingsResult result) {
        updateSettingsResult(result);
        // update data if needed
        if (result.isCurrencyChanged()) {
            update();
        }
    }

    @Override
    public void onBackPressed() {
        if (settingsResult != null) {
            view.closeActivityWithResult(settingsResult);
        } else {
            view.closeActivity();
        }
    }

    @Override
    public void destroy() {
        view = null;
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private void fetchDetails() {
        view.showLoading();
        disposable = repository.getCurrencyDetails(currency.getId())
                .map(currencyEntity -> mapper.mapFromData(currencyEntity))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onFetchingSuccess, this::onFetchingError);
    }

    private void onFetchingSuccess(CryptoCurrency currency) {
        if (view != null) {
            view.buildAndShowCurrencyDetails(currency, repository.getSelectedFiatCurrency());
            view.hideLoading();
        }
    }

    private void onFetchingError(Throwable throwable) {
        if (view != null) {
            view.showLoadingError();
            view.hideLoading();
        }
    }

    private void updateSettingsResult(SettingsResult result) {
        if (settingsResult == null) {
            settingsResult = result;
        } else {
            // save only positive values, since result will be propagated to list activity
            if (result.isCurrencyChanged() && !settingsResult.isCurrencyChanged()) {
                settingsResult.setCurrencyChanged(true);
            }
            if (result.isLimitChanged() && !settingsResult.isLimitChanged()) {
                settingsResult.setLimitChanged(true);
            }
        }
    }

}
