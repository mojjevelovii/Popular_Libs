package ru.shumilova.popular_libs.task1;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "ASYNC_TAG";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                Log.d(TAG, "doInBackground: " + Thread.currentThread().getName() + ": " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
