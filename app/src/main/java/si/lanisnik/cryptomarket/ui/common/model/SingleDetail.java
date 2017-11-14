package si.lanisnik.cryptomarket.ui.common.model;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public class SingleDetail {
    private String title;
    private String value;

    public SingleDetail(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }
}
