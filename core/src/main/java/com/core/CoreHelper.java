package com.core;

import android.util.Log;

import java.util.Random;

/**
 * Created by darrenrobinson on 3/9/18.
 */
public final class CoreHelper {
    private static final String words[] = {
        "copper", "explain", "branch"
    };
    
    final String valueFoo = "Foo";
    final String valueBar = "Bar";
    final String uniqueWord;
    
    public CoreHelper(Core core) {
        uniqueWord = core.getCoreName() + getRandomWord();
    }
    
    public static String getRandomWord() {
        Random r = new Random(System.currentTimeMillis());
        int pick = Math.abs(r.nextInt()) % 3;
        Log.e("foo", "mod: " + pick);
        return words[pick] + r.nextInt();
    }
    
    public String getValueFoo() {
        return valueFoo;
    }
    
    public String getValueBar() {
        return valueBar;
    }
    
    public String getUniqueWord() {
        return uniqueWord;
    }
}
