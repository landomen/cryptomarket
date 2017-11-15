package si.lanisnik.cryptomarket.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import si.lanisnik.cryptomarket.ui.common.model.CryptoCurrency;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public class DataHelper {

    public List<CryptoCurrency> loadCurrenciesFromJson() {
        String json = loadJson("top100.json");
        return new Gson().fromJson(json, new TypeToken<List<CryptoCurrency>>() {
        }.getType());
    }

    public String loadJson(String file) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line);
            }
            in.close();
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
