package ru.shumilova.popular_libs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Task1Activity extends AppCompatActivity {
    private Button button;
    public static final String TAG = "ASYNC_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_1);

        initView();
        initButton();
    }

    private void initView() {
        button = findViewById(R.id.b_button);
    }

    private void initButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
                Log.d(TAG, "initButton: " + Thread.currentThread().getName() + " Метод, вызвавший AsyncTask, завершен.");
            }
        });
    }


}