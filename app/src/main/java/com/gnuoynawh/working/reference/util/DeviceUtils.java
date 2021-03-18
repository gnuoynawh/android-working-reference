package com.gnuoynawh.working.reference.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.util.Log;

public class DeviceUtils {

    /**
     * 전화번호 가져오
     * @param context
     * @return
     */
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getPhoneNumber(Context context) {
        try {
            TelephonyManager tMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tMgr != null) {
                String num = PhoneNumberUtils.formatNumber(tMgr.getLine1Number(), "KR");
                num = removeSpecialCharacters(num);
                num = replaceCountryCode(num);

                return PhoneNumberUtils.formatNumber(num, "KR");
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    private static String removeSpecialCharacters(String str){
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        str =str.replaceAll(match, "");
        return str;
    }

    private static String replaceCountryCode(String str) {
        if(str.startsWith("82"))
            return "0" + str.substring(2);
        else
            return str;
    }

    /**
     * 디바이스 아이디 가져오기
     */
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getDeviceId(Context context) {
        try {
            TelephonyManager tMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tMgr != null) {
                return tMgr.getDeviceId();
            } else {
                return "";
            }
        } catch (Exception e) {
            Log.e("TEST", "getDeviceID = " + e.getMessage());
            return "";
        }
    }


    /**
     * 네트워크 체크
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.getType() == ConnectivityManager.TYPE_MOBILE || networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            }
        }
        return false;
    }

}
