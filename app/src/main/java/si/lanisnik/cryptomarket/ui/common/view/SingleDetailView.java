package si.lanisnik.cryptomarket.ui.common.view;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import si.lanisnik.cryptomarket.R;

/**
 * Small view that displays title and value texts.
 * <p>
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class SingleDetailView extends RelativeLayout {

    @BindView(R.id.single_detail_title_text_view)
    protected TextView titleTextView;

    @BindView(R.id.single_detail_value_text_view)
    protected TextView valueTextView;

    public SingleDetailView(Context context) {
        super(context);
        init(context);
    }

    public SingleDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setTitleAndValue(String title, String value) {
        titleTextView.setText(title);
        valueTextView.setText(value);
    }

    public void setTitleAndValue(@StringRes int titleRes, String value) {
        setTitleAndValue(getContext().getString(titleRes), value);
    }

    private void init(Context context) {
        inflate(context, R.layout.view_single_detail, this);
        ButterKnife.bind(this);
    }
}
