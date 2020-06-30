package ru.shumilova.popular_libs.task2;

import android.util.Log;

public class ObserverImpl implements Observer {
    public static final String TAG = "OBSERV_TAG";

    @Override
    public void updateData(String name, int num) {
        Log.d(TAG, "updateData: " + Thread.currentThread().getName());
    }
}
