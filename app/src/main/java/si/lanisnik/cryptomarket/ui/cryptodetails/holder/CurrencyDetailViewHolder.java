package si.lanisnik.cryptomarket.ui.cryptodetails.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import si.lanisnik.cryptomarket.ui.common.model.SingleDetail;
import si.lanisnik.cryptomarket.ui.common.view.SingleDetailView;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyDetailViewHolder extends RecyclerView.ViewHolder {

    private SingleDetailView singleDetailView;

    public CurrencyDetailViewHolder(View itemView) {
        super(itemView);
        this.singleDetailView = (SingleDetailView) itemView;
    }

    public void bind(SingleDetail singleDetail) {
        singleDetailView.setTitleAndValue(singleDetail.getTitle(), singleDetail.getValue());
    }
}
