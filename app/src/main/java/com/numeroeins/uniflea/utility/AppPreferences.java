package com.numeroeins.uniflea.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yashtongaonkar on 09/11/17.
 */

public class AppPreferences {

    private static final String FILE_NAME = "uniflea.shapref";
    private static final String USER_ID = "userId";

    public static void setUserId(Context context, String value) {
        SharedPreferences preferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        preferences.edit().putString(USER_ID,value).apply();
    }

    public static String getUserId(Context context){
        SharedPreferences preferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return preferences.getString(USER_ID,"");
    }
}
