package com.codeiatic.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    TextView equationTV;
    TextView answerTV;

    String answer = "";
    String equation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equationTV = findViewById(R.id.equation);
        answerTV = findViewById(R.id.answer);
    }

    public void numberClick(View view) {
        String val = ((Button) view).getText().toString();
        equation += val;
        equationTV.setText(equation);
    }

    public void equalsClick(View view) {
        if (!(equation.endsWith("+")|| equation.startsWith("*") || equation.startsWith("/") || equation.endsWith("-") || equation.endsWith("*") || equation.endsWith("/"))) {
            Expression expression = new ExpressionBuilder(equation).build();
            try {
                double result = expression.evaluate();
                answer = String.valueOf(result);
            } catch (ArithmeticException e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }

            answerTV.setText(answer);
        }
        else {
            answerTV.setText("Invalid Equation");
            equation = "";
        }
    }

    public void addClick(View view) {
        String val = ((Button) view).getText().toString();
        equation += val;
        equationTV.setText(equation);
    }

    public void divideClick(View view) {
        String val = ((Button) view).getText().toString();
        equation += val;
        equationTV.setText(equation);
    }

    public void delClick(View view) {
        equation = "";
        equationTV.setText(equation);
        answer = "";
        answerTV.setText(answer);
    }

    public void multiplyClick(View view) {
        String val = ((Button) view).getText().toString();
        equation += val;
        equationTV.setText(equation);
    }

    public void minusClick(View view) {
        String val = ((Button) view).getText().toString();
        equation += val;
        equationTV.setText(equation);
    }
}
