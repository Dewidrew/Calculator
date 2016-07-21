package com.augmentis.ayp.calculator;

import java.util.Stack;

/**
 * Created by Hattapong on 7/21/2016.
 */
public class SimpleCalculator {
    private Stack<String> calStack;

    public SimpleCalculator() {
        calStack = new Stack<>();
    }

    public void addOperand(String operand) {
        calStack.push(operand);
//      }else if(calStack.pop().equals("+") || calStack.pop().equals("-") || calStack.pop().equals("*") ||calStack.pop().equals("/")){
//          calculate(operand);
//      }
    }

    public String addOperator(String operator) {
        if (!operator.equals("=")) {
            if (calStack.size() == 1) {
                return calculate(operator);
            } else if (calStack.size() == 3) {
                calculate(calStack.pop());
                return calculate(operator);
            }
        } else { // operator "="
            if (calStack.size() == 2) {
                String tOperator = calStack.pop();
                String tOperand = calStack.pop();
                calStack.push(tOperand);
                calStack.push(tOperator);
                return calculate(tOperand);
            }else if (calStack.size() == 3) {
                calculate(calStack.pop());
                return calculate(operator);
            }
        }
        return null;
    }

    public String calculate(String operand) {
        if (calStack.pop().equals("+")) {
            int b = Integer.parseInt(operand);
            int a = Integer.parseInt(calStack.pop());
            calStack.push(Integer.toString(a + b));
            return Integer.toString(a + b);
        } else if (calStack.pop().equals("-")) {
            int b = Integer.parseInt(operand);
            int a = Integer.parseInt(calStack.pop());
            calStack.push(Integer.toString(a - b));
            return Integer.toString(a - b);
        } else if (calStack.pop().equals("*")) {
            int b = Integer.parseInt(operand);
            int a = Integer.parseInt(calStack.pop());
            calStack.push(Integer.toString(a * b));
            return Integer.toString(a * b);
        } else if (calStack.pop().equals("/")) {
            int b = Integer.parseInt(operand);
            int a = Integer.parseInt(calStack.pop());
            calStack.push(Integer.toString(a / b));
            return Integer.toString(a / b);
        }
        return null;
    }


}
