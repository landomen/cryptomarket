package si.lanisnik.cryptomarket.ui.cryptolist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import si.lanisnik.cryptomarket.R;
import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.common.util.CurrencyConverter;
import si.lanisnik.cryptomarket.ui.cryptolist.holder.CurrencyViewHolder;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyRecyclerAdapter extends RecyclerView.Adapter<CurrencyViewHolder> {

    private Context context;
    private List<CryptoCurrency> currencies;
    private OnCurrencySelectedListener listener;
    private FiatCurrencyType fiatCurrency;
    private CurrencyConverter converter;

    public CurrencyRecyclerAdapter(Context context, FiatCurrencyType fiatCurrency,
                                   CurrencyConverter converter, OnCurrencySelectedListener listener) {
        this.currencies = new ArrayList<>();
        this.context = context;
        this.listener = listener;
        this.converter = converter;
        this.fiatCurrency = fiatCurrency;
    }

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CurrencyViewHolder(inflater.inflate(R.layout.recycler_item_currency, parent, false));
    }

    @Override
    public void onBindViewHolder(CurrencyViewHolder holder, int position) {
        CryptoCurrency currency = currencies.get(position);

        // set display values
        holder.setRank(currency.getRank());
        holder.setSymbol(currency.getSymbol());
        holder.setChange24h(currency.getPercentChange24h());
        holder.setPrice(context.getString(R.string.price_fiat, fiatCurrency.name()),
                converter.getPrice(currency, fiatCurrency));

        // listen for clicks
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCurrencySelected(currency);
            }
        });
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public void setCurrencies(List<CryptoCurrency> currencies) {
        this.currencies = currencies;
        notifyDataSetChanged();
    }

    public void setFiatCurrency(FiatCurrencyType fiatCurrency) {
        this.fiatCurrency = fiatCurrency;
    }

    public interface OnCurrencySelectedListener {
        void onCurrencySelected(CryptoCurrency currency);
    }
}
