package lab4.exceptions;

public class InputMismatchException extends RuntimeException {
    @Override
    public String toString() {
        return "Не верный ввод, введите число от 1 до 5";
    }
}
