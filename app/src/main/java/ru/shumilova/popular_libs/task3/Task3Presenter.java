package ru.shumilova.popular_libs.task3;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Task3Presenter {
    private static final String TAG = "RxJAVA_TAG";

    public Observable<String> getMsg() {
        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    String msg = "msg " + i;
                    Log.d(TAG, "Get msg: " + Thread.currentThread().getName() + ": " + msg);
                    emitter.onNext(msg);
                }
                emitter.onComplete();
            } catch (InterruptedException e) {
                if (!emitter.isDisposed()) {
                    emitter.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }
}
