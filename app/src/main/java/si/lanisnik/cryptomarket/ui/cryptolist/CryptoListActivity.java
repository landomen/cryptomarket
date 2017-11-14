package si.lanisnik.cryptomarket.ui.cryptolist;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import si.lanisnik.cryptomarket.R;
import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.ui.Navigator;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.common.util.CurrencyConverter;
import si.lanisnik.cryptomarket.ui.cryptolist.adapter.CurrencyRecyclerAdapter;

public class CryptoListActivity extends AppCompatActivity implements CryptoListContract.View,
        CurrencyRecyclerAdapter.OnCurrencySelectedListener, SwipeRefreshLayout.OnRefreshListener {

    private static final int REQUEST_CODE_DETAILS = 1984;

    @BindView(R.id.crypto_list_swipe_refresh_layout)
    protected SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.crypto_list_recycler_view)
    protected RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @Inject
    CryptoListPresenter presenter;
    @Inject
    Navigator navigator;
    private CurrencyRecyclerAdapter currencyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_list);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);

        initPresenter();
    }

    @Override
    public void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void setupAdapter(FiatCurrencyType fiatCurrency, CurrencyConverter converter) {
        currencyAdapter = new CurrencyRecyclerAdapter(this, fiatCurrency, converter, this);
        recyclerView.setAdapter(currencyAdapter);
    }

    @Override
    public void setupSwipeLayout() {
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void showCurrencies(List<CryptoCurrency> currencies, FiatCurrencyType fiatCurrencyType) {
        currencyAdapter.setFiatCurrency(fiatCurrencyType);
        currencyAdapter.setCurrencies(currencies);
    }

    @Override
    public void showLoadingError() {
        Toast.makeText(this, R.string.error_general, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        if (!swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onCurrencySelected(CryptoCurrency currency) {
        navigator.navigateToDetails(this, currency, REQUEST_CODE_DETAILS);
    }

    @Override
    public void onRefresh() {
        presenter.update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_list_settings) {
            presenter.onSettingsClicked();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initPresenter() {
        presenter.setView(this);
        presenter.initialize();
    }

}
