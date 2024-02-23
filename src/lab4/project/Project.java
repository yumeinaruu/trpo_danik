package lab4.project;

import lab4.exceptions.InputMismatchException;
import lab4.workers.Group;
import lab4.workers.Worker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Project extends PhasesStorage {
    private Group[] groups;
    private Scanner scanner = new Scanner(System.in);
    private LocalDate date;

    public Project(Group[] groups) {
        this.groups = groups;
    }

    public void assignTheGroup(Group group) {
        System.out.println("На какую фазу записать эту группу?");
        System.out.println("""
                1.Разработка ТЗ
                2.Проектирование
                3.Кодирование
                4.Тестирование
                5.Пробная эксплуатация""");
        boolean check = true;
        while (check) {
            try {
                int phase = scanner.nextInt();
                if (phase <= 5 && phase >= 1) {
                    group.setPhase(phases[phase - 1]);
                    check = false;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
        }
    }

    public void schedule() {
        date = LocalDate.now().plusDays(7);
        System.out.println("------------------");
        System.out.println("График сдачи работ: ");
        for (Group group : groups) {
            System.out.println(group.getPhase() + " - с " + date + " по " + date.plusDays(7));
            date = date.plusDays(7);
        }
        System.out.println("------------------");
    }

    public void setGroups() {
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Group();
            System.out.println("------------------");
            System.out.println("Введите название группы: ");
            groups[i].setGroupName("Группа " + scanner.next());
            System.out.println("----------");
            System.out.println("Первый сотрудник: ");
            groups[i].setFirstWorker(new Worker());
            System.out.println("----------");
            System.out.println("Второй сотрудник: ");
            groups[i].setSecondWorker(new Worker());
            System.out.println("------------------");
            assignTheGroup(groups[i]);
        }
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Группы:\n" + Arrays.toString(groups);
    }
}
