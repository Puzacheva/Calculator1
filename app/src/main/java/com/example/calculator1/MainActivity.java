package com.example.calculator1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.activity.ComponentActivity;

public class MainActivity extends ComponentActivity {

    String operator = "";
    String oldNumber;
    Boolean isNew = true;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        editText = findViewById(R.id.editText);
    }

    public void clickNumber(View view) {
        if (isNew)
            editText.setText("");
        isNew = false;
        String number = editText.getText().toString();
        int id = view.getId();
        if (id == R.id.but1) {
            number = number + "1";
        } else if (id == R.id.but2) {
            number = number + "2";
        } else if (id == R.id.but3) {
            number = number + "3";
        } else if (id == R.id.but4) {
            number = number + "4";
        } else if (id == R.id.but5) {
            number = number + "5";
        } else if (id == R.id.but6) {
            number = number + "6";
        } else if (id == R.id.but7) {
            number = number + "7";
        } else if (id == R.id.but8) {
            number = number + "8";
        } else if (id == R.id.but9) {
            number = number + "9";
        } else if (id == R.id.but0) {
            number = number + "0";
        } else if (id == R.id.butDot) {
            if (dotIsPresent(number)) {

            } else {
                number = number + ".";
            }
        } else if (id == R.id.butPlusMinus) {
            if (minusIsPresent(number)) {
               number = number.substring(1);
            } else {
                number = "-" + number;
            }
        }

        editText.setText(number);
    }

    public void operation(View view) {
        isNew = true;
        oldNumber = editText.getText().toString();
        int id = view.getId();
        if (id == R.id.butMinus) {
            operator = "-";
        } else if (id == R.id.butPlus) {
            operator = "+";
        } else if (id == R.id.butDivide) {
            operator = "/";
        } else if (id == R.id.butMultiply) {
            operator = "*";
        }
        editText.setText(oldNumber + operator);
    }

    public void clickEqual(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        if (operator == "-") {
            result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
        }
        if (operator == "+") {
            result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
        }
        if (operator == "*") {
            result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
        }
        if (operator == "/") {
            result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
        }
        editText.setText(result + "");
    }

    public void acClick(View view) {
        editText.setText("0");
        isNew = true;
    }

    public boolean dotIsPresent(String number) {
        if (number.indexOf(".") == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean minusIsPresent(String number) {
        if (number.charAt(0) == '-') {
            return true;
        } else {
            return false;
        }
    }

    public void clickPercent (View view) {
        if (operator == "") {
            String number = editText.getText().toString();
            double temp = Double.parseDouble(number) / 100;
            number = temp+"";
            editText.setText(number);
        } else {
            Double result = 0.0;
            String newNumber = editText.getText().toString();
            if (operator == "-") {
                result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
            }
            if (operator == "+") {
                result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
            }
            if (operator == "*") {
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
            }
            if (operator == "/") {
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) * 100;
            }
            editText.setText(result+"");
            operator = "";
        }
    }
}




