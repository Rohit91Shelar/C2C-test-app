package com.numeroeins.uniflea.utility;

import android.util.Log;

/**
 * Created by yashtongaonkar on 09/11/17.
 */

public class Utils {

    public static String getUrlForPage(String page) {
        String url = String.format("%s/%s", Constants.URL, page);
        Log.d("Utils", url);
        return url;
    }


}
