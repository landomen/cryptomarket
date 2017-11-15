package si.lanisnik.cryptomarket;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.cryptolist.util.CurrencySearchFilter;
import si.lanisnik.cryptomarket.util.DataHelper;

import static org.junit.Assert.assertEquals;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencySearchFilterTest {

    private List<CryptoCurrency> currencies;
    private CurrencySearchFilter searchFilter;

    @Before
    public void setup() {
        currencies = new DataHelper().loadCurrenciesFromJson();
        searchFilter = new CurrencySearchFilter();
    }

    @Test
    public void testIncreasingQuery() {
        assertEquals(55, searchFilter.filterCurrencies(currencies, "e").size());
        assertEquals(11, searchFilter.filterCurrencies(currencies, "et").size());
        assertEquals(3, searchFilter.filterCurrencies(currencies, "eth").size());
        assertEquals(2, searchFilter.filterCurrencies(currencies, "ethere").size());
        assertEquals(2, searchFilter.filterCurrencies(currencies, "ethereum").size());
        assertEquals(true, searchFilter.filterCurrencies(currencies, "ethereus").isEmpty());
    }

    @Test
    public void testDecreasingQuery() {
        assertEquals(3, searchFilter.filterCurrencies(currencies, "bitcoin").size());
        assertEquals(4, searchFilter.filterCurrencies(currencies, "bitc").size());
        assertEquals(7, searchFilter.filterCurrencies(currencies, "bit").size());
        assertEquals(10, searchFilter.filterCurrencies(currencies, "bi").size());
        assertEquals(19, searchFilter.filterCurrencies(currencies, "b").size());
        assertEquals(100, searchFilter.filterCurrencies(currencies, "").size());
    }

    @Test
    public void testUpperLowerMixedCase() {
        int lower = searchFilter.filterCurrencies(currencies, "bit").size();
        int upper = searchFilter.filterCurrencies(currencies, "BIT").size();
        int mixed = searchFilter.filterCurrencies(currencies, "BiT").size();

        assertEquals(lower, upper);
        assertEquals(upper, mixed);
    }

    @Test
    public void testClearQuery() {
        assertEquals(3, searchFilter.filterCurrencies(currencies, "bitcoin").size());
        assertEquals(100, searchFilter.filterCurrencies(currencies, "").size());
    }

    @Test
    public void testQueryWithSpace() {
        assertEquals(1, searchFilter.filterCurrencies(currencies, "n c").size());
    }

}
