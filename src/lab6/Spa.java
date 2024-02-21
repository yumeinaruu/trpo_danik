package lab6;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Spa extends Thread {
    Scanner scanner = new Scanner(System.in);
    private final static Semaphore sem = new Semaphore(1, true);
    private final String[] procedures = {"Массаж", "Пилинг", "Маникюр", "Педикюр", "Лечебный массаж", "Лечебный пилинг"};
    private final int[] prices = {1000, 1500, 500, 700, 1500, 2000};

    public void run() {
        try {
            sem.acquire();
            System.out.println("Добро пожаловать в наш салон!");
            System.out.println("Выберите процедуры из списка: ");
            for (int i = 0; i < procedures.length; i++) {
                System.out.println((i + 1) + ". " + procedures[i] + " - " + prices[i] + " рублей");
            }
            System.out.println("Введите номера процедур через пробел: ");
            String[] clientChoice = scanner.nextLine().split(" ");
            int sum = 0;
            for (String procedure : clientChoice) {
                sum += prices[Integer.parseInt(procedure) - 1];
            }
            System.out.println("Сумма к оплате: " + sum + " рублей\n");
            sem.release();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

