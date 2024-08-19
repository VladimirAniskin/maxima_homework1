package homework9;

public class TwoNumbers {
    public static int sum(int a, int b) {
        int c;
        c = a + b;
        return c;
    }

    public static int raznost(int a, int b) {
        int d;
        d = a - b;
        return d;
    }

    public static int umnojenie(int a, int b) {
        if (a == 0 || b == 0) {
            throw new ArithmeticException("Вообще на ноль умножать можно, но Олег попросил ");
        } else {
            int f;
            f = a * b;
            return f;
        }
    }

    public static double chasnoe(double a, double b) {
        if (a == 0 || b == 0) {
            throw new ArithmeticException("На ноль делить нельзя!!!");
        } else {
            double g;
            g = a / b;
            return g;
        }
    }

    public static int exponentiation(int a, int b) {
        if (a == 0) {
            throw new ArithmeticException("Если ноль возводить в степень это число всегда будет равно нулю");
        } else if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else {
            return a * exponentiation(a, b - 1);
        }
    }
}
