package si.lanisnik.cryptomarket.ui.cryptodetails.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import si.lanisnik.cryptomarket.ui.common.model.SingleDetail;
import si.lanisnik.cryptomarket.ui.common.view.SingleDetailView;
import si.lanisnik.cryptomarket.ui.cryptodetails.holder.CurrencyDetailViewHolder;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyDetailsRecyclerAdapter extends RecyclerView.Adapter<CurrencyDetailViewHolder> {

    private List<SingleDetail> details;

    @Inject
    public CurrencyDetailsRecyclerAdapter() {
        details = new ArrayList<>();
    }

    @Override
    public CurrencyDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SingleDetailView singleDetailView = new SingleDetailView(parent.getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        singleDetailView.setLayoutParams(layoutParams);
        return new CurrencyDetailViewHolder(singleDetailView);
    }

    @Override
    public void onBindViewHolder(CurrencyDetailViewHolder holder, int position) {
        holder.bind(details.get(position));
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public void setDetails(List<SingleDetail> details) {
        this.details = details;
        notifyDataSetChanged();
    }
}
