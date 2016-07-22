package com.augmentis.ayp.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.StringTokenizer;

import static com.augmentis.ayp.calculator.R.color.colorAccent;
import static com.augmentis.ayp.calculator.R.color.gray;

public class CalActivity extends AppCompatActivity {
    private TextView main, sub;
    private String subSentence;
    private String operand, operator;
    private Button ansBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        operand = "";
        subSentence = "";
        main = (TextView) findViewById(R.id.cal_lcd);
        sub = (TextView) findViewById(R.id.cal_sentence);
        ansBtn = (Button) findViewById(R.id.cal_ans);
        ansBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    ansBtn.setBackgroundResource(gray);
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ansBtn.setBackgroundResource(R.color.colorAccent);
                }
                return false;
            }
        });

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
                    case "\u00D7":
                        ans = ans * b;
                        break;
                    case "\u00F7":
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

    public void buttonClicked(final View view) {
        if(view.getId() != R.id.cal_ans) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        v.setBackgroundResource(gray);
                    } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        v.setBackgroundColor(Color.parseColor("#808080"));
                    }
                    return false;
                }
            });
        }
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
                subSentence += String.valueOf(Integer.parseInt(operand)) + " + ";
            }
            operator = "+";
            main.setText(operand);
            sub.setText(subSentence);

        } else if (view.getId() == R.id.cal_minus) {
            if (operator != null) {
                subSentence = subSentence.substring(0,subSentence.length()-2) + "- ";
            }else {
                subSentence += String.valueOf(Integer.parseInt(operand)) + " - ";
            }
            operator = "-";
            main.setText(operand);
            sub.setText(subSentence);

        } else if (view.getId() == R.id.cal_divide) {
            if (operator != null) {
                subSentence = subSentence.substring(0,subSentence.length()-2) + "\u00F7 ";
            }else {
                subSentence += String.valueOf(Integer.parseInt(operand)) + " \u00F7 ";
            }
            operator = "\u00F7";
            main.setText(operand);
            sub.setText(subSentence);

        } else if (view.getId() == R.id.cal_multi) {
            if (operator != null) {
                subSentence = subSentence.substring(0,subSentence.length()-2) + "\u00D7 ";
            }else {
                subSentence += String.valueOf(Integer.parseInt(operand)) + " \u00D7 ";
            }
            operator = "\u00D7";
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