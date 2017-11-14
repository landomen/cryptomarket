package si.lanisnik.cryptomarket.ui.cryptolist.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import si.lanisnik.cryptomarket.R;
import si.lanisnik.cryptomarket.ui.common.view.SingleDetailView;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.currency_rank_detail_view)
    protected SingleDetailView rankDetailView;

    @BindView(R.id.currency_symbol_detail_view)
    protected SingleDetailView symbolDetailView;

    @BindView(R.id.currency_price_detail_view)
    protected SingleDetailView priceDetailView;

    @BindView(R.id.currency_24h_change_detail_view)
    protected SingleDetailView changeDetailView;


    public CurrencyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setRank(String rank) {
        rankDetailView.setTitleAndValue(R.string.rank, rank);
    }

    public void setSymbol(String symbol) {
        symbolDetailView.setTitleAndValue(R.string.symbol, symbol);
    }

    public void setChange24h(String change24h) {
        changeDetailView.setTitleAndValue(R.string.change_24h, change24h);
    }

    public void setPrice(String title, String price) {
        priceDetailView.setTitleAndValue(title, price);
    }

}
