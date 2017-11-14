package si.lanisnik.cryptomarket.ui;

import android.app.Activity;
import android.content.Intent;

import org.parceler.Parcels;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.cryptodetails.CryptoDetailsActivity;

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

}
