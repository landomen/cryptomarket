package si.lanisnik.cryptomarket.ui.common.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.R;
import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.common.model.SingleDetail;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyDetailsBuilder {

    private CurrencyConverter converter;

    @Inject
    public CurrencyDetailsBuilder(CurrencyConverter converter) {
        this.converter = converter;
    }

    public List<SingleDetail> buildDetails(Context context, CryptoCurrency currency, FiatCurrencyType fiatCurrency) {
        List<SingleDetail> details = new ArrayList<>();
        details.add(new SingleDetail(context.getString(R.string.rank), currency.getRank()));
        details.add(new SingleDetail(context.getString(R.string.name), currency.getName()));
        details.add(new SingleDetail(context.getString(R.string.symbol), currency.getSymbol()));
        details.add(new SingleDetail(context.getString(R.string.price_fiat), converter.getPrice(currency, fiatCurrency)));
        details.add(new SingleDetail(context.getString(R.string.volume_24h), converter.getVolume(currency, fiatCurrency)));
        details.add(new SingleDetail(context.getString(R.string.market_cap), converter.getMarketCap(currency, fiatCurrency)));
        details.add(new SingleDetail(context.getString(R.string.price_btc), currency.getPriceBtc()));
        details.add(new SingleDetail(context.getString(R.string.change_1h), currency.getPercentChange1h()));
        details.add(new SingleDetail(context.getString(R.string.change_24h), currency.getPercentChange24h()));
        details.add(new SingleDetail(context.getString(R.string.change_7d), currency.getPercentChange7d()));
        return details;
    }

}
