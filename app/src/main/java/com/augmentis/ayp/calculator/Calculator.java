package com.augmentis.ayp.calculator;

import java.util.StringTokenizer;

/**
 * Created by Hattapong on 7/22/2016.
 */
public class Calculator {
    private int result;
    private String primaryScreen,secondaryScreen;
    private int state; // 0 = start, 1 = operand, 2 = operator;

    public Calculator() {
        result = 0;
        primaryScreen = "0";
        secondaryScreen = "";
        state = 0;
    }

    public void pressNumber(String s) {
        if(state == 0){// Case Start
            primaryScreen = s;
            state = 1;
        }else if(state == 1){// Case Input Operand (0,1,2,...)
            primaryScreen += " "+s;
        }else{// Case Input Operator
            primaryScreen = s;
            state = 1;
        }


    }

    public void pressOperator(String s) {
        if(s.equals("+")){// Plus Case
            if(isOperator(secondaryScreen.charAt(secondaryScreen.length() - 1))){
                secondaryScreen = secondaryScreen.substring(0,secondaryScreen.length() - 2) + "+";
            }else{
            }

        }else if(s.equals("-")){// Minus Case
            if(isOperator(secondaryScreen.charAt(secondaryScreen.length() - 1))){
                secondaryScreen = secondaryScreen.substring(0,secondaryScreen.length() - 2) + "-";
            }

        }else if(s.equals("*")){// Multi Case
            if(isOperator(secondaryScreen.charAt(secondaryScreen.length() - 1))){
                secondaryScreen = secondaryScreen.substring(0,secondaryScreen.length() - 2) + "*";
            }

        }else {// Divide Case
            if(isOperator(secondaryScreen.charAt(secondaryScreen.length() - 1))){
                secondaryScreen = secondaryScreen.substring(0,secondaryScreen.length() - 2) + "/";
            }

        }
    }

    public void pressEqual() {
        if(!secondaryScreen.equals("")){
            secondaryScreen += " "+ primaryScreen;
        }
    }

    public int getResult() {
        int ans = 0;
        boolean first = true;
        StringTokenizer st = new StringTokenizer(secondaryScreen, " ");
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
        secondaryScreen = "";
        return result = ans;
    }

    private boolean isOperator(char s){
        switch (s){
            case '+':return true;
            case '-':return true;
            case '*':return true;
            case '/':return true;
            default:return false;
        }

    }
}
