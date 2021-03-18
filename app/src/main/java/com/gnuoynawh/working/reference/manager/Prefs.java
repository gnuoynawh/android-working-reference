package com.gnuoynawh.working.reference.manager;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import androidx.core.content.ContextCompat;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;

public class Prefs {

    private static SharedPreferences mPref;

    public static void init(Context context) {
        mPref = context.getSharedPreferences(context.getPackageName(), ContextWrapper.MODE_PRIVATE);
    }

    public static SharedPreferences getPreferences() {
        if (mPref != null) {
            return mPref;
        } else {
            throw new RuntimeException("Initialize this class in Application.create() first.");
        }
    }

    public static SharedPreferences.Editor clear() {
        SharedPreferences.Editor editor = null;
        if (getPreferences() != null) {
            editor = getPreferences().edit().clear();
            editor.apply();
        }
        return editor;
    }

    public static SharedPreferences.Editor delete(String key) {
        SharedPreferences.Editor editor = null;
        if (getPreferences() != null) {
            editor = getPreferences().edit().remove(key);
            editor.apply();
        }
        return editor;
    }

    public static boolean hasKey(final String key) {
        return getPreferences().contains(key);
    }

    ///////////////////////////////////////////
    // 출력
    //////////////////////////////////////////

    public static String getString(final String key) {
        return getPreferences().getString(key, "");
    }

    public static int getInt(final String key) {
        return getPreferences().getInt(key, -1);
    }

    public static long getLong(final String key) {
        return getPreferences().getLong(key, -1L);
    }

    public static float getFloat(final String key) {
        return getPreferences().getFloat(key, -1F);
    }

    public static boolean getBoolean(final String key) {
        return getPreferences().getBoolean(key, false);
    }

    public static boolean getBoolean(final String key, final boolean defBoolean) {
        return getPreferences().getBoolean(key, defBoolean);
    }

    public static ArrayList<String> getStringArray(String key) {
        String json = getPreferences().getString(key, null);
        ArrayList<String> urls = new ArrayList<String>();
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }

    ///////////////////////////////////////////
    // 입력
    //////////////////////////////////////////

    public static void putString(final String key, final String defValue) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(key, defValue);
        editor.apply();
    }

    public static void putInt(final String key, final int defValue) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt(key, defValue);
        editor.apply();
    }

    public static void putLong(final String key, final long defValue) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putLong(key, defValue);
        editor.apply();
    }

    public static void putFloat(final String key, final float defValue) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putFloat(key, defValue);
        editor.apply();
    }

    public static void putBoolean(final String key, final boolean defValue) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(key, defValue);
        editor.apply();
    }

    public static void putStringArray(String key, ArrayList<String> values) {
        SharedPreferences.Editor editor = getPreferences().edit();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
    }
}
