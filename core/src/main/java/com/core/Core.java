package com.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.core.CoreEvents.Event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 */
public final class Core {
    
    private static final ExecutorService execSrvc = Executors.newCachedThreadPool();
    private static Core instance = null;
    private static Handler uiHandler = null;
    
    public static void execute(Runnable command) {
        execSrvc.execute(command);
    }
    
    public synchronized static Core getDefaultInstance() {
        return instance;
    }
    
    public static void post(Runnable runnable) {
        if (uiHandler == null) {
            uiHandler = new Handler(Looper.getMainLooper());
        }
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            uiHandler.post(runnable);
        }
    }
    
    public static void initCore(final Context context, final String coreName) {
        if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        }
        
        execute(new Runnable() {
            @Override
            public void run() {
                synchronized (Core.class) {
                    if (instance == null) {
                        instance = new Core(context, coreName);
                    }
                    
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    CoreEvents.updateAll(Event.CORE_INIT);
                }
            }
        });
    }
    
    private final Context context;
    private final CoreHelper coreHelper;
    private final String coreName;
    
    private Core(Context context, String coreName) {
        this.context = context.getApplicationContext();
        this.coreName = coreName;
        coreHelper = new CoreHelper(this);
    }
    
    public Context getContext() {
        return context;
    }
    
    public String getCoreName() {
        return coreName;
    }
    
    public String getUniqueWord() {
        return coreHelper.getUniqueWord();
    }
}
