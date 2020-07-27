package ru.shumilova.popular_libs;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class MyBus {
    private PublishSubject<Long> subject = PublishSubject.create();

    public MyBus() {
        Observer<Long> observer = new Observer<Long>() {
            long count;

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Long aLong) {
                count++;
                if (count % 3 == 0) {
                    subject.onNext(count);
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
            }
        };
        subject.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public PublishSubject<Long> getSubject() {
        return subject;
    }
}
