package ru.shumilova.popular_libs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.shumilova.popular_libs.task1.Task1Activity;
import ru.shumilova.popular_libs.task2.Task2Activity;

public class MainActivity extends AppCompatActivity {
    private Button task1;
    private Button task2;
    private Button task3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initButtons();
    }

    private void initView() {
        task1 = findViewById(R.id.b_task_1);
        task2 = findViewById(R.id.b_task_2);
        task3 = findViewById(R.id.b_task_3);
    }

    private void initButtons() {
        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Task1Activity.class));
            }
        });

        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Task2Activity.class));
            }
        });

        task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Task3Activity.class));
            }
        });
    }
}