package com.core.foo;

import android.text.TextUtils;

import com.core.Core;

/**
 * Created by robinsda on 3/9/18.
 */
public class FooService {
    
    public static String getFooedName(Core core, String src) {
        if (TextUtils.isEmpty(src)) {
            return "noFoo" + core.getCoreName();
        }
        return src.replaceAll("coopper", "foo") + "fooed" + core.getCoreName();
    }
}
