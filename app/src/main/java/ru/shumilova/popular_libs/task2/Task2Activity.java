package ru.shumilova.popular_libs.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ru.shumilova.popular_libs.R;

public class Task2Activity extends AppCompatActivity {
    private Button subscribe;
    private Button unsubscribe;
    private Button spam;

    Observer observer = new ObserverImpl();
    Observable observable = new ObservableImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_2);

        initView();
        initButtons();
    }

    private void initView() {
        subscribe = findViewById(R.id.b_subscribe);
        unsubscribe = findViewById(R.id.b_unsubscribe);
        spam = findViewById(R.id.b_spam);
    }

    private void initButtons() {
        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.subscribe(observer);
            }
        });

        unsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.unsubscribe(observer);
            }
        });

        spam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.spam();
            }
        });
    }

}