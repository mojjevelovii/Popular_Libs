package ru.shumilova.popular_libs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView {
    private EditText enterText;
    private TextView showText;
    private TextView observerOne;
    private TextView observerTwo;
    private Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        enterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showText.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        presenter.setMainView(this);
        presenter.initPresenter();
    }

    private void initView() {
        enterText = findViewById(R.id.et_enter_text);
        showText = findViewById(R.id.tv_show_text);
        observerOne = findViewById(R.id.tv_observer_one);
        observerTwo = findViewById(R.id.tv_observer_two);
    }

    @Override
    public void onOne(long data) {
        observerOne.append(" " + data);
    }

    @Override
    public void onTwo(long data) {
        observerTwo.append(" " + (char) data);
    }
}