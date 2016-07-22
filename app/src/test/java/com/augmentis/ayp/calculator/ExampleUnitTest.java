package com.augmentis.ayp.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void test_1_add_1_equals_2(){
        Calculator calculator = new Calculator();
        calculator.pressNumber("1");
        calculator.pressOperator("+");
        calculator.pressNumber("1");
        calculator.pressEqual();

        int calculatorResult = calculator.getResult();

        assertEquals(2,calculatorResult);

    }
}