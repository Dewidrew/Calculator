package com.augmentis.ayp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.StringTokenizer;

public class CalActivity extends AppCompatActivity {
    //    private Button one,two,three;
//    private Button four,five,six;
//    private Button seven,eight,nine;
//    private Button zero,clear,ans;
//    private Button plus,minus,divide,multi;
    private TextView main, sub;
    private String mainSentence;
    private String subSentence;
    private String operand, operator;
    private SimpleCalculator sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        sc = new SimpleCalculator();
        operand = "";
        subSentence = "";
        main = (TextView) findViewById(R.id.cal_lcd);
        sub = (TextView) findViewById(R.id.cal_sentence);
    }

    public String calculate() {
        int ans = 0;
        boolean first = true;
        StringTokenizer st = new StringTokenizer(subSentence, " ");
        while (st.hasMoreTokens()) {
            if (first) {
                ans = Integer.parseInt(st.nextToken());
                first = false;
            } else {
                String op = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                switch (op) {
                    case "+":
                        ans = ans + b;
                        break;
                    case "-":
                        ans = ans - b;
                        break;
                    case "*":
                        ans = ans * b;
                        break;
                    case "/":
                        ans = ans / b;
                        break;
                    default:
                        break;
                }

            }
        }
        subSentence = "";
        return Integer.toString(ans);
    }

    public void buttonClicked(View view) {
        if (view.getId() == R.id.cal_one) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "1");
        } else if (view.getId() == R.id.cal_two) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "2");
        } else if (view.getId() == R.id.cal_three) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "3");
        } else if (view.getId() == R.id.cal_four) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "4");
        } else if (view.getId() == R.id.cal_five) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "5");
        } else if (view.getId() == R.id.cal_six) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "6");
        } else if (view.getId() == R.id.cal_seven) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "7");
        } else if (view.getId() == R.id.cal_eight) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "8");
        } else if (view.getId() == R.id.cal_nine) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "9");
        } else if (view.getId() == R.id.cal_zero) {
            if (operator != null) {
                operand = "";
            }
            operator = null;
            main.setText(operand += "0");
        } else if (view.getId() == R.id.cal_plus) {
            if (operator != null) {
                subSentence = subSentence.substring(0,subSentence.length()-2) + "+ ";
            }else {
                subSentence += operand + " + ";
            }
            operator = "+";
            main.setText(operand);
            sub.setText(subSentence);

        } else if (view.getId() == R.id.cal_minus) {
            if (operator != null) {
                subSentence = subSentence.substring(0,subSentence.length()-2) + "- ";
            }else {
                subSentence += operand + " - ";
            }
            operator = "-";
            main.setText(operand);
            sub.setText(subSentence);

        } else if (view.getId() == R.id.cal_divide) {
            if (operator != null) {
                subSentence = subSentence.substring(0,subSentence.length()-2) + "/ ";
            }else {
                subSentence += operand + " / ";
            }
            operator = "/";
            main.setText(operand);
            sub.setText(subSentence);

        } else if (view.getId() == R.id.cal_multi) {
            if (operator != null) {
                subSentence = subSentence.substring(0,subSentence.length()-2) + "* ";
            }else {
                subSentence += operand + " * ";
            }
            operator = "*";
            main.setText(operand);
            sub.setText(subSentence);

        } else if (view.getId() == R.id.cal_clear) {
            operand = "";
            operator = "";
            subSentence = "";
            main.setText(operand);
            sub.setText(subSentence);


        } else if (view.getId() == R.id.cal_ans) {
            subSentence += operand;
            operator = null;
            main.setText(operand = calculate());
            sub.setText(subSentence);

        }
    }
}