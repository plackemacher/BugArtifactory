package com.core.muu;

import android.text.TextUtils;

import com.core.Core;

/**
 * Created by robinsda on 3/9/18.
 */
public class MuuService {
    
    public static String getMuuName(Core core, String src) {
        if (TextUtils.isEmpty(src)) {
            return "Mooooo" + core.getCoreName();
        }
        return src.replaceAll("explain", "muu") + "Mooooo" + core.getCoreName();
    }
}
