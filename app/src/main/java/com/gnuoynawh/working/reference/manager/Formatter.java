package com.gnuoynawh.working.reference.manager;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatter {

    ///////////////////////////////////////////
    // 돈
    //////////////////////////////////////////

    /**
     * 금액 포맷으로 변경
     * @param num
     * @return
     */
    public static String getMoneyString(int num) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(num);
    }

    /**
     * 금액 포맷으로 변경
     * @param num
     * @return
     */
    public static String getMoneyString(String num) {
        if(TextUtils.isEmpty(num))
            return "0";
        else {
            DecimalFormat df = new DecimalFormat("#,###");
            return df.format(Integer.valueOf(num));
        }
    }

    ///////////////////////////////////////////
    // 검증
    //////////////////////////////////////////

    /**
     * 이메일 포맷 검증
     * @param email
     * @return
     */
    public static boolean isValidEmail(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);

        return m.matches();
    }
}
