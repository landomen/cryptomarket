package si.lanisnik.cryptomarket.ui.cryptolist;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import si.lanisnik.cryptomarket.data.entities.CurrencyEntity;
import si.lanisnik.cryptomarket.data.source.CurrencyRepository;
import si.lanisnik.cryptomarket.ui.common.mapper.CryptoCurrencyMapper;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.common.util.CurrencyConverter;

/**
 * Created by Domen Lanišnik on 13/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CryptoListPresenter implements CryptoListContract.Presenter {

    private CurrencyRepository repository;
    private CryptoCurrencyMapper modelMapper;
    private CurrencyConverter currencyConverter;
    private CryptoListContract.View view;
    private Disposable disposable;

    @Inject
    public CryptoListPresenter(CurrencyRepository repository, CurrencyConverter currencyConverter, CryptoCurrencyMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.currencyConverter = currencyConverter;
    }

    @Override
    public void setView(CryptoListContract.View view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        setupView();
        fetchTopCurrencies();
    }

    @Override
    public void update() {
        fetchTopCurrencies();
    }

    @Override
    public void onSettingsClicked() {
        view.openSettings();
    }

    @Override
    public void destroy() {
        this.view = null;
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private void setupView() {
        view.setupToolbar();
        view.setupSwipeLayout();
        view.setupRecyclerView();
        view.setupAdapter(repository.getSelectedFiatCurrency(), currencyConverter);
    }

    private void fetchTopCurrencies() {
        view.showLoading();
        disposable = repository.getTopCurrencies()
                .map(this::mapToViewModels)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onFetchingSuccess, this::onFetchingError);
    }

    private List<CryptoCurrency> mapToViewModels(List<CurrencyEntity> entities) {
        List<CryptoCurrency> currencies = new ArrayList<>(entities.size());
        for (CurrencyEntity entity : entities) {
            currencies.add(modelMapper.mapFromData(entity));
        }
        return currencies;
    }

    private void onFetchingSuccess(List<CryptoCurrency> currencies) {
        if (view != null) {
            view.showCurrencies(currencies, repository.getSelectedFiatCurrency());
            view.hideLoading();
        }
    }

    private void onFetchingError(Throwable throwable) {
        if (view != null) {
            view.showLoadingError();
            view.hideLoading();
        }
    }
}
