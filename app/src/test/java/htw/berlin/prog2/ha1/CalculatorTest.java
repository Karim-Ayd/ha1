package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("should display positive result after division of two positive numbers")
    void testPositiveDivision(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display at most 10 characters on screen")
    void testScreenLengthLimit(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(7);
        calc.pressEqualsKey();

        String expected = "1.28571428";
        String actual = calc.readScreen();

        System.out.println(actual);
        System.out.println(actual.length());

        assertEquals(true, actual.length()<= 10);
    }

    @Test
    @DisplayName("should only clear screen on first press of C and full reeset on second")
    void testClearKey(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressClearKey();
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("should not allow two points in one number")

    void testDoubleDot(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressDotKey();
        calc.pressDigitKey(6);
        calc.pressDotKey();
        calc.pressDigitKey(7);

        String expected = "5.67";
        String actual = calc.readScreen();

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("should not write a negative sign before 0")
    void testNegativeKeyOnZero(){
        Calculator calc = new Calculator();

        calc.pressNegativeKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}


