import homework9.TwoNumbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Запуск нашего теста")
public class TwoNubersTest {
    private TwoNumbers twoNubers = new TwoNumbers();

    @ParameterizedTest
    @CsvSource(value = {"7,3,4", "6,1,5"})
    @DisplayName("Проверка суммы")
    public void sum(int a, int b, int c) {
        assertEquals(a, twoNubers.sum(b, c));

    }

    @ParameterizedTest
    @CsvSource(value = {"5,7,2", "6,7,1"})
    @DisplayName("Проверка разности")
    public void raznost(int a, int b, int c) {
        assertEquals(a, twoNubers.raznost(b, c));

    }

    @Test
    @DisplayName("Проверка умножения")
    public void umnojenie() {
        assertEquals(6, twoNubers.umnojenie(6, 1));

    }

    @Test
    @DisplayName("Проверка ошибки умножения")
    public void umnojenieException() {
        assertThrows(ArithmeticException.class, () -> twoNubers.umnojenie(0, 1));

    }

    @Test
    @DisplayName("Проверка деления")
    public void chasnoe() {
        assertEquals(6, twoNubers.chasnoe(6, 1));
    }

    @Test
    @DisplayName("Проверка ошибки деления")
    public void chasnoeException() {
        assertThrows(ArithmeticException.class, () -> twoNubers.chasnoe(0, 1));
    }

    @Test
    @DisplayName("Проверка возведения в степени на 1")
    public void exponentiation() {
        assertEquals(6, twoNubers.exponentiation(6, 1));
    }

    @Test
    @DisplayName("Проверка возведения в степенина 0")
    public void exponentiation0() {
        assertEquals(1, twoNubers.exponentiation(6, 0));
    }

    @Test
    @DisplayName("Проверка возведения в степень")
    public void exponentiation1() {
        assertEquals(36, twoNubers.exponentiation(6, 2));
    }

    @Test
    @DisplayName("Проверка ошибки возведения в степень")
    public void exponentiationException() {
        assertThrows(ArithmeticException.class, () -> twoNubers.exponentiation(0, 1));
    }


}
