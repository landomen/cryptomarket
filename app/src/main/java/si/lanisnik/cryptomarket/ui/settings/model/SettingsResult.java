package si.lanisnik.cryptomarket.ui.settings.model;

import org.parceler.Parcel;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
@Parcel(Parcel.Serialization.BEAN)
public class SettingsResult {
    private boolean currencyChanged;
    private boolean limitChanged;

    public SettingsResult() {

    }

    public SettingsResult(boolean currencyChanged, boolean limitChanged) {
        this.currencyChanged = currencyChanged;
        this.limitChanged = limitChanged;
    }

    public boolean isCurrencyChanged() {
        return currencyChanged;
    }

    public void setCurrencyChanged(boolean currencyChanged) {
        this.currencyChanged = currencyChanged;
    }

    public boolean isLimitChanged() {
        return limitChanged;
    }

    public void setLimitChanged(boolean limitChanged) {
        this.limitChanged = limitChanged;
    }
}
