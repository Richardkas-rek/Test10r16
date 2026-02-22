package com.example.test10r16;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText display;

    double memory = 0;
    String operator = "";
    boolean isNewNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }

    public void operatorClick(View view) {

        double currentNumber = Double.parseDouble(display.getText().toString());

        if (operator.equals("")) {
            memory = currentNumber;
        } else {
            calculate(currentNumber);
        }

        operator = ((Button)view).getText().toString();
        isNewNumber = true;   // говорим что следующее число новое
    }

    public void equalsClick(View view) {

        double currentNumber = Double.parseDouble(display.getText().toString());
        calculate(currentNumber);

        operator = "";
        isNewNumber = true;
    }

    private void calculate(double currentNumber) {

        switch (operator) {
            case "+":
                memory += currentNumber;
                break;
            case "-":
                memory -= currentNumber;
                break;
            case "*":
                memory *= currentNumber;
                break;
            case "/":
                memory /= currentNumber;
                break;
        }

        display.setText(String.valueOf(memory));
    }

    // ЭТО ГЛАВНОЕ — очищаем поле при новом числе
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        display.setOnClickListener(v -> {
            if (isNewNumber) {
                display.setText("");
                isNewNumber = false;
            }
        });
    }

    public void clearClick(View view) {
        display.setText("");
        memory = 0;
        operator = "";
        isNewNumber = true;
    }
}