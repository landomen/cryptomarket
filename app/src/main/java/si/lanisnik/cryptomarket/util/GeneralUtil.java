package si.lanisnik.cryptomarket.util;

import android.support.annotation.Nullable;

/**
 * Created by Domen Lanišnik on 15/11/2017.
 * domen.lanisnik@gmail.com
 */
public class GeneralUtil {

    /**
     * Tries the parse the given string to an integer.
     *
     * @param possibleNumber
     * @return Parsed int or null if string couldn't be parsed
     */
    @Nullable
    public static Integer safeParseInt(@Nullable String possibleNumber) {
        if (possibleNumber != null && !possibleNumber.isEmpty()) {
            try {
                return Integer.parseInt(possibleNumber);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
