package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleNumberCalculatorTest {

    private TriangleNumberCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TriangleNumberCalculator();
    }

    @Test
    void testValueBaseCases() {
        assertEquals(0, calculator.value(0));
        assertEquals(1, calculator.value(1));
    }

    @Test
    void testValueGeneralCases() {
        assertEquals(3, calculator.value(2));
        assertEquals(6, calculator.value(3));
        assertEquals(10, calculator.value(4));
        assertEquals(15, calculator.value(5));
    }

    @Test
    void testAdd() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(9, calculator.add(2, 3)); 
        assertEquals(13, calculator.add(4, 2));
    }

    @Test
    void testSubtract() {
        assertEquals(0, calculator.subtract(1, 1));
        assertEquals(-3, calculator.subtract(2, 3));
        assertEquals(7, calculator.subtract(4, 2)); 
    }

    @Test
    void testMultiply() {
        assertEquals(18, calculator.multiply(2, 3));  
        assertEquals(0, calculator.multiply(0, 5));  
    }

    @Test
    void testDivideValid() {
        assertEquals(10.0 / 3.0, calculator.divide(4, 2), 0.0001);
        assertEquals(1.0, calculator.divide(2, 2), 0.0001);
    }

    @Test
    void testDivideByZeroTriangularNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(4, 0);
        });
        assertEquals("Cannot divide by zero triangular number.", exception.getMessage());
    }

    @Test
    void testSequence() {
        List<Integer> expected = List.of(1, 3, 6, 10, 15);
        assertEquals(expected, calculator.sequence(5));
    }

    @Test
    void testEmptySequence() {
        assertEquals(List.of(), calculator.sequence(0));
    }
}
