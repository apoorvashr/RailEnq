package com.example.apoo.railwayprojectapoorva.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Apoo on 5/26/2017.
 */

public class MySharedPrefrence  {

    private static final String RAILWAY_APP_SHARED_PREF_FILE_NAME = "";
    private static final String TRAINNAME = "trainname";
    private static final String TRAINNUMBER = "trainnumber";
    private static final String TRAINPOSITION = "trainnposition";
    private static final String LOGIN_MESSAGE = "login_message";

    public static void setTrainName(Context context, String value) {
        SharedPreferences preferences = context.getSharedPreferences(RAILWAY_APP_SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        preferences.edit().putString(TRAINNAME, value).apply();
    }

    public static String getTrainName(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(RAILWAY_APP_SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getString(TRAINNAME, "");
    }

    public static void setTrainNumber(Context context, String value) {
        SharedPreferences preferences = context.getSharedPreferences(RAILWAY_APP_SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        preferences.edit().putString(TRAINNUMBER, value).apply();
    }

    public static String getTrainNumber(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(RAILWAY_APP_SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getString(TRAINNUMBER, "");
    }

    public static void setTrainPosition(Context context, String value) {
        SharedPreferences preferences = context.getSharedPreferences(RAILWAY_APP_SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        preferences.edit().putString(TRAINPOSITION, value).apply();
    }

    public static String getTrainposition(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(RAILWAY_APP_SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getString(TRAINPOSITION, "");
    }

    public static void setLoginMessage(Context context, int value) {
        SharedPreferences preferences = context.getSharedPreferences(RAILWAY_APP_SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        preferences.edit().putInt(LOGIN_MESSAGE, value).apply();
    }

    public static int getLoginMessage(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(RAILWAY_APP_SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(LOGIN_MESSAGE, 0);
    }
}
