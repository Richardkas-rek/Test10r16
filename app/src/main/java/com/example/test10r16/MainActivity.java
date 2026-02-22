package com.example.test10r16;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText display;

    double memory = 0;
    String x = "";
    boolean newNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }

    public void operatorClick(View view) {

        Button button = (Button) view;
        double currentNumber = Double.parseDouble(display.getText().toString());

        if (!x.equals("")) {
            calculate(currentNumber);
        } else {
            memory = currentNumber;
        }

        x = button.getText().toString();
        newNumber = true;
    }

    public void equalsClick(View view) {

        double currentNumber = Double.parseDouble(display.getText().toString());
        calculate(currentNumber);

        x = "";
        newNumber = true;
    }

    private void calculate(double currentNumber) {

        switch (x) {
            case "+":
                memory = memory + currentNumber;
                break;

            case "-":
                memory = memory - currentNumber;
                break;

            case "*":
                memory = memory * currentNumber;
                break;

            case "/":
                memory = memory / currentNumber;
                break;
        }

        display.setText(String.valueOf(memory));
    }

    public void clearClick(View view) {
        display.setText("");
        memory = 0;
        x = "";
        newNumber = true;
    }
}