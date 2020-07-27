package ru.shumilova.popular_libs;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Presenter {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS).take(10);
    private MyBus myBus = new MyBus();
    private MainView mainView;

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    private Observer<Long> observerOne = new Observer<Long>() {
        @Override
        public void onSubscribe(Disposable d) {
            compositeDisposable.add(d);
        }

        @Override
        public void onNext(Long aLong) {
            mainView.onOne(aLong);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    private Observer<Long> observerTwo = new Observer<Long>() {
        @Override
        public void onSubscribe(Disposable d) {
            compositeDisposable.add(d);
        }

        @Override
        public void onNext(Long aLong) {
            mainView.onTwo( 97 + aLong);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    public void initPresenter() {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myBus.getSubject());

        myBus.getSubject().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerOne);

        myBus.getSubject().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerTwo);
    }
}

