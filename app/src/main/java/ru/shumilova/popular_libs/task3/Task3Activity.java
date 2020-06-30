package ru.shumilova.popular_libs.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import ru.shumilova.popular_libs.R;

public class Task3Activity extends AppCompatActivity {
    private Button subscribe;
    private Button unsubscribe;
    private Disposable disposable;
    private static final String TAG = "RxJAVA_TAG";

    Task3Presenter presenter = new Task3Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_3);

        initView();
        initButtons();
    }

    private void initView() {
        subscribe = findViewById(R.id.b_subscribe);
        unsubscribe = findViewById(R.id.b_unsubscribe);
    }

    private void initButtons() {
        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getMsg()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<String>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                disposable = d;
                            }

                            @Override
                            public void onNext(@NonNull String msg) {
                                Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + msg);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete: " + Thread.currentThread().getName());
                            }
                        });
            }
        });

        unsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (disposable!=null){
                    disposable.dispose();
                }
            }
        });
    }
}