package com.saeed.calculatorjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.saeed.calculatorjava.R;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);

        // Number button listeners
        View.OnClickListener numberListener = v -> {
            Button button = (Button) v;
            if (isOperatorClicked) {
                resultText.setText("");
                isOperatorClicked = false;
            }
            String currentText = resultText.getText().toString();
            resultText.setText(currentText + button.getText().toString());
        };

        // Assign listeners to number buttons
        findViewById(R.id.btn0).setOnClickListener(numberListener);
        findViewById(R.id.btn1).setOnClickListener(numberListener);
        findViewById(R.id.btn2).setOnClickListener(numberListener);
        findViewById(R.id.btn3).setOnClickListener(numberListener);
        findViewById(R.id.btn4).setOnClickListener(numberListener);
        findViewById(R.id.btn5).setOnClickListener(numberListener);
        findViewById(R.id.btn6).setOnClickListener(numberListener);
        findViewById(R.id.btn7).setOnClickListener(numberListener);
        findViewById(R.id.btn8).setOnClickListener(numberListener);
        findViewById(R.id.btn9).setOnClickListener(numberListener);

        // Operator button listeners
        findViewById(R.id.btnAdd).setOnClickListener(v -> handleOperator("+"));
        findViewById(R.id.btnSub).setOnClickListener(v -> handleOperator("-"));
        findViewById(R.id.btnMul).setOnClickListener(v -> handleOperator("*"));
        findViewById(R.id.btnDiv).setOnClickListener(v -> handleOperator("/"));

        // Equal button
        findViewById(R.id.btnEqual).setOnClickListener(v -> handleEqual());

        // Clear button
        findViewById(R.id.btnClear).setOnClickListener(v -> clear());
    }

    private void handleOperator(String op) {
        firstNumber = Double.parseDouble(resultText.getText().toString());
        operator = op;
        isOperatorClicked = true;
    }

    private void handleEqual() {
        secondNumber = Double.parseDouble(resultText.getText().toString());
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    resultText.setText("Error");
                    return;
                }
                break;
        }
        resultText.setText(String.valueOf(result));
    }

    private void clear() {
        firstNumber = 0;
        secondNumber = 0;
        operator = "";
        resultText.setText("");
    }
}
