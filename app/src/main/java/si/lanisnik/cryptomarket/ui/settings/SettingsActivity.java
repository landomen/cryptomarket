package si.lanisnik.cryptomarket.ui.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import si.lanisnik.cryptomarket.R;
import si.lanisnik.cryptomarket.ui.Navigator;
import si.lanisnik.cryptomarket.ui.settings.model.SettingsResult;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public class SettingsActivity extends AppCompatActivity implements SettingsContract.View {

    @BindView(R.id.settings_currency_spinner)
    protected Spinner currencySpinner;

    @BindView(R.id.settings_limit_edit_text)
    protected EditText limitEditText;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @Inject
    SettingsContract.Presenter presenter;
    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        initPresenter();
    }

    @Override
    public void setupToolbar() {
        setSupportActionBar(toolbar);
        setTitle(R.string.settings_title);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    @Override
    public void setupCurrencySpinner(String[] currencies) {
        ArrayAdapter<String> currencyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencies);
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(currencyAdapter);
    }

    @Override
    public void setCurrencySpinnerPosition(int position) {
        currencySpinner.setSelection(position);
    }

    @Override
    public void setLimitValue(int limit) {
        limitEditText.setText(String.valueOf(limit));
    }

    @Override
    public void showSaveMessage() {
        Toast.makeText(this, R.string.settings_saved, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void closeActivityWithResult(SettingsResult result) {
        navigator.navigateBackWithSettingsResult(this, result);
    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed(currencySpinner.getSelectedItemPosition(), limitEditText.getText().toString());
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    private void initPresenter() {
        presenter.setView(this);
        presenter.initialize();
    }

}
