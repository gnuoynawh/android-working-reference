package com.gnuoynawh.working.reference.manager;

import android.util.Log;

import com.gnuoynawh.working.reference.BuildConfig;

public class L {

    static final String TAG = "TEST";

    public static void e(String message) { e(TAG, message); }
    public static void w(String message) { w(TAG, message); }
    public static void i(String message) { i(TAG, message); }
    public static void d(String message) { d(TAG, message); }
    public static void v(String message) { v(TAG, message); }

    /** Log Level Error **/
    public static void e(String tag, String message) {
        if (BuildConfig.DEBUG)
            Log.e(tag, buildLogMsg(message));
    }
    /** Log Level Warning **/
    public static void w(String tag, String message) {
        if (BuildConfig.DEBUG)
            Log.w(tag, buildLogMsg(message));
    }
    /** Log Level Information **/
    public static void i(String tag, String message) {
        if (BuildConfig.DEBUG)
            Log.i(tag, buildLogMsg(message));
    }
    /** Log Level Debug **/
    public static void d(String tag, String message) {
        if (BuildConfig.DEBUG)
            Log.d(tag, buildLogMsg(message));
    }
    /** Log Level Verbose **/
    public static void v(String tag, String message) {
        if (BuildConfig.DEBUG)
            Log.v(tag, buildLogMsg(message));
    }

    public static String buildLogMsg(String message) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(ste.getFileName().replace(".java", ""));
        sb.append("::");
        sb.append(ste.getMethodName());
        sb.append("]");
        sb.append(message);
        return sb.toString();
    }
}
