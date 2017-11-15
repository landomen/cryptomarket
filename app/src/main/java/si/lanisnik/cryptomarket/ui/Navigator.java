package si.lanisnik.cryptomarket.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;

import org.parceler.Parcels;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.ui.common.constants.ActivityConstants;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.cryptodetails.CryptoDetailsActivity;
import si.lanisnik.cryptomarket.ui.settings.SettingsActivity;
import si.lanisnik.cryptomarket.ui.settings.model.SettingsResult;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToDetails(Activity activity, CryptoCurrency currency, int requestCode) {
        Intent detailsIntent = new Intent(activity, CryptoDetailsActivity.class);
        detailsIntent.putExtra(CryptoDetailsActivity.EXTRA_CRYPTO_CURRENCY, Parcels.wrap(currency));
        activity.startActivityForResult(detailsIntent, requestCode);
    }

    public void navigateToSettings(Activity activity, int requestCode) {
        Intent settingsIntent = new Intent(activity, SettingsActivity.class);
        activity.startActivityForResult(settingsIntent, requestCode);
    }

    public void navigateBackWithSettingsResult(Activity activity, @Nullable SettingsResult result) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(ActivityConstants.EXTRA_SETTINGS_RESULT, Parcels.wrap(result));
        activity.setResult(Activity.RESULT_OK, resultIntent);
        activity.finish();
    }

}
