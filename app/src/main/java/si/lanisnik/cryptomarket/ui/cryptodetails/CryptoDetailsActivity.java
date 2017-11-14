package si.lanisnik.cryptomarket.ui.cryptodetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import si.lanisnik.cryptomarket.R;
import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.common.model.SingleDetail;
import si.lanisnik.cryptomarket.ui.common.util.CurrencyDetailsBuilder;
import si.lanisnik.cryptomarket.ui.cryptodetails.adapter.CurrencyDetailsRecyclerAdapter;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CryptoDetailsActivity extends AppCompatActivity implements CryptoDetailsContract.View, SwipeRefreshLayout.OnRefreshListener {

    public static final String EXTRA_CRYPTO_CURRENCY = CryptoDetailsActivity.class.getPackage() + "CryptoCurrency";

    @BindView(R.id.crypto_details_swipe_refresh_layout)
    protected SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.crypto_details_recycler_view)
    protected RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @Inject
    CryptoDetailsContract.Presenter presenter;
    @Inject
    CurrencyDetailsRecyclerAdapter detailsAdapter;
    @Inject
    CurrencyDetailsBuilder detailsBuilder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_details);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        initPresenter();
    }

    @Override
    public void setupToolbar(String title) {
        setSupportActionBar(toolbar);
        setTitle(title);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(detailsAdapter);
    }

    @Override
    public void setupSwipeLayout() {
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void buildAndShowCurrencyDetails(CryptoCurrency currency, FiatCurrencyType fiatCurrencyType) {
        List<SingleDetail> details = detailsBuilder.buildDetails(this, currency, fiatCurrencyType);
        detailsAdapter.setDetails(details);
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
    public void onRefresh() {
        presenter.update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_details_settings:
                presenter.onSettingsClicked();
                return true;
            case android.R.id.home:
                // TODO
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initPresenter() {
        CryptoCurrency cryptoCurrency = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_CRYPTO_CURRENCY));
        presenter.setView(this);
        presenter.initialize(cryptoCurrency);
    }

}