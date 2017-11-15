package si.lanisnik.cryptomarket;

import org.junit.Before;
import org.junit.Test;

import si.lanisnik.cryptomarket.data.entities.FiatCurrencyType;
import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;
import si.lanisnik.cryptomarket.ui.common.util.CurrencyConverter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public class CurrencyConverterTest {

    private CryptoCurrency cryptoCurrency;
    private CurrencyConverter currencyConverter;

    @Before
    public void prepare() {
        cryptoCurrency = mock(CryptoCurrency.class);
        currencyConverter = new CurrencyConverter();
    }

    @Test
    public void testGetPriceForFiatCurrency() {
        when(cryptoCurrency.getPriceCny()).thenReturn("3000");
        when(cryptoCurrency.getPriceUsd()).thenReturn("2000");
        when(cryptoCurrency.getPriceEur()).thenReturn("1000");

        assertEquals("2000", currencyConverter.getPrice(cryptoCurrency, FiatCurrencyType.USD));
        assertEquals("3000", currencyConverter.getPrice(cryptoCurrency, FiatCurrencyType.CNY));
        assertEquals("1000", currencyConverter.getPrice(cryptoCurrency, FiatCurrencyType.EUR));
    }

    @Test
    public void testGetVolumeForFiatCurrency() {
        when(cryptoCurrency.getVolume24hCny()).thenReturn("10000.20");
        when(cryptoCurrency.getVolume24hUsd()).thenReturn("10000.30");
        when(cryptoCurrency.getVolume24hEur()).thenReturn("10000.40");

        assertEquals("10000.20", currencyConverter.getVolume(cryptoCurrency, FiatCurrencyType.CNY));
        assertEquals("10000.30", currencyConverter.getVolume(cryptoCurrency, FiatCurrencyType.USD));
        assertEquals("10000.40", currencyConverter.getVolume(cryptoCurrency, FiatCurrencyType.EUR));
    }

    @Test
    public void testGetMarketCapForFiatCurrency() {
        when(cryptoCurrency.getMarketCapCny()).thenReturn("1");
        when(cryptoCurrency.getMarketCapUsd()).thenReturn("2");
        when(cryptoCurrency.getMarketCapEur()).thenReturn("3");

        assertEquals("1", currencyConverter.getMarketCap(cryptoCurrency, FiatCurrencyType.CNY));
        assertEquals("2", currencyConverter.getMarketCap(cryptoCurrency, FiatCurrencyType.USD));
        assertEquals("3", currencyConverter.getMarketCap(cryptoCurrency, FiatCurrencyType.EUR));
    }

}
