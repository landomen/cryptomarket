package si.lanisnik.cryptomarket.ui.cryptolist.util;

import android.support.v7.util.DiffUtil;

import java.util.List;

import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyDiffCallback extends DiffUtil.Callback {

    private List<CryptoCurrency> oldCurrencies;
    private List<CryptoCurrency> newCurrencies;

    public CurrencyDiffCallback(List<CryptoCurrency> oldCurrencies, List<CryptoCurrency> newCurrencies) {
        this.oldCurrencies = oldCurrencies;
        this.newCurrencies = newCurrencies;
    }

    @Override
    public int getOldListSize() {
        return oldCurrencies.size();
    }

    @Override
    public int getNewListSize() {
        return newCurrencies.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCurrencies.get(oldItemPosition).getId().equals(newCurrencies.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCurrencies.get(oldItemPosition).equals(newCurrencies.get(newItemPosition));
    }
}
