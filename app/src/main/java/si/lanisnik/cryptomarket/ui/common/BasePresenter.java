package si.lanisnik.cryptomarket.ui.common;

/**
 * Created by Domen Lanišnik on 14/11/2017.
 * domen.lanisnik@gmail.com
 */
public interface BasePresenter<T extends BaseView> {

    /**
     * Sets the view reference.
     *
     * @param view
     */
    void setView(T view);

    /**
     * Perform any final cleanup, the view is going to be destroyed.
     */
    void destroy();
}
