package com.gnuoynawh.working.reference.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VersionChecker extends AsyncTask<String, String, String> {

    // fixme Test PackageName - gmail
    private String packageName = "com.google.android.gm";

    @Override
    protected String doInBackground(String... params) {
        String newVersion = "";

        try {
            Document document = Jsoup.connect("https://play.google.com/store/apps/details?id=" + packageName + "&hl=en")
                    .timeout(30000)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com").get();

            if (document != null) {
                Elements element = document.getElementsContainingOwnText("Current Version");
                for (Element ele : element) {
                    if (ele.siblingElements() != null) {
                        Elements sibElemets = ele.siblingElements();
                        for (Element sibElemet : sibElemets) {
                            newVersion = sibElemet.text();
                        }
                    }
                }
            }
            return newVersion;
        }catch (Exception e) {
            return newVersion;
        }
    }
}