import java.util.ArrayList;
import java.util.List;

public class TriangleNumberCalculator {

    public int value(int n) {
        if (n <= 1) return n;
        return n + value(n - 1);
    }

    public int add(int n, int m) {
        return value(n) + value(m);
    }

    public int subtract(int n, int m) {
        return value(n) - value(m);
    }

    public int multiply(int n, int m) {
        return value(n) * value(m);
    }

    public double divide(int n, int m) {
        int denominator = value(m);
        if (denominator == 0) {
            throw new IllegalArgumentException("Division by zero triangular number");
        }
        return (double) value(n) / denominator;
    }

    public List<Integer> sequence(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(value(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TriangleNumberCalculator calculator = new TriangleNumberCalculator();

        System.out.println(calculator.value(1)); 
        System.out.println(calculator.value(2)); 
        System.out.println(calculator.value(4));

        System.out.println(calculator.add(1, 1));
        System.out.println(calculator.add(2, 3)); 
        System.out.println(calculator.add(4, 2)); 

        System.out.println(calculator.subtract(1, 1));
        System.out.println(calculator.subtract(2, 3));
        System.out.println(calculator.subtract(4, 2));

        System.out.println(calculator.multiply(2, 3));
        System.out.println(calculator.divide(4, 2)); 

        System.out.println(calculator.sequence(5)); 
    }
}
