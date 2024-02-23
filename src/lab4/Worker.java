package lab4;

import java.util.Scanner;

public class Worker {
    private Scanner scanner = new Scanner(System.in);
    private String fio;
    private Group group;

    public String getFio() {
        return fio;
    }

    public Worker() {
        System.out.println("Введите ФИО сотрудника: ");
        this.fio = scanner.nextLine();
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
