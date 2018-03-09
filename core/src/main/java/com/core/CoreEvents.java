package com.core;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by robinsda on 3/9/18.
 */
public class CoreEvents {
    
    public interface Updatable {
        void onEvent(Event event);
    }
    
    public enum Event {
        CORE_INIT;
    }
    
    private static final List<WeakReference<Updatable>> observers = new ArrayList<>();
    
    
    public static void updateAll(final Event event) {
        synchronized (observers) {
            Iterator<WeakReference<Updatable>> iter = observers.iterator();
            while (iter.hasNext()) {
                final Updatable cb = iter.next().get();
                if (cb == null) {
                    iter.remove();
                    continue;
                }
                Core.post(new Runnable() {
                    @Override
                    public void run() {
                        cb.onEvent(event);
                    }
                });
            }
        }
    }
    
    public static void addObserver(Updatable ref) {
        synchronized (observers) {
            Iterator<WeakReference<Updatable>> iter = observers.iterator();
            while (iter.hasNext()) {
                Updatable cb = iter.next().get();
                if (cb == null) {
                    iter.remove();
                    continue;
                }
                if (cb == ref) {
                    return;
                }
            }
            observers.add(new WeakReference<>(ref));
        }
    }
}
