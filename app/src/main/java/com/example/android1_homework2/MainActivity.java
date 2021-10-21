package com.example.android1_homework2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnOpen;
    private EditText etEmail;
    private EditText etPassword;
    private ConstraintLayout clContent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnOpen = findViewById(R.id.btn_open);
        clContent = findViewById(R.id.cl_content);
        toolbar = findViewById(R.id.toolbar);

        btnOpen.setOnClickListener(v -> {
            if (etEmail.getText().toString().equals("admin@gmail.com") && etPassword.getText().toString().equals("admin")) {
                clContent.setVisibility(View.GONE);
                toolbar.setVisibility(View.GONE);
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
            }
        });

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setBackground();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setBackground();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void setBackground() {
        if (!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {
            btnOpen.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.dr_rad_open_orange));
        } else {
            btnOpen.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.dr_rad_open));
        }
    }
}