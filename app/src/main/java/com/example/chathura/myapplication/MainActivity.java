package com.example.chathura.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String CLASS_NAME = MainActivity.class.getSimpleName();
    private EditText firstNumberInput;
    private EditText secondNumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberInput = (EditText) findViewById(R.id.firstNumberInput);
        secondNumberInput = (EditText) findViewById(R.id.secondNumberInput);
    }

    /**
     * Based on the clicked button perform the calculation for user inputs.
     *
     * @param view An instance passed by the click event.
     */
    public void calculate(View view) {
        double firstNumber = Double.parseDouble(firstNumberInput.getText().toString());
        double secondNumber = Double.parseDouble(secondNumberInput.getText().toString());
        Log.d(CLASS_NAME, "String Message");

        switch (view.getId()) {
            case R.id.plusButton:
                showResult(add(firstNumber, secondNumber));
                break;
            case R.id.minusButton:
                showResult(subtract(firstNumber, secondNumber));
                break;
            case R.id.multiplyButton:
                showResult(multiply(firstNumber, secondNumber));
                break;
            case R.id.divisionButton:
                showResult(divide(firstNumber, secondNumber));
                break;
            default:
                Toast.makeText(getApplicationContext(), "No calculation found", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Returns the addition of two double values.
     *
     * @param firstNumber
     * @param secondNumber
     * @return the addition of firstNumber and secondNumber
     */
    protected double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    protected double subtract(double firstNumber, double secondNumber) {
        if (firstNumber > secondNumber) {
            return firstNumber - secondNumber;
        } else {
            Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    protected double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    protected double divide(double firstNumber, double secondNumber) {
        if (secondNumber != 0) {
            return firstNumber / secondNumber;
        } else {
            return 0;
        }
    }

    private void showResult(double result) {
        TextView resultView = (TextView) findViewById(R.id.resultsView);
        resultView.setText(Double.toString(result));
    }
}
