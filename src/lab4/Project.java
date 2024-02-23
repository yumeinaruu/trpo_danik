package lab4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

// Разработка IT – проекта. Основные фазы разработки проекта:
// разработка ТЗ, проектирование, кодирование, тестирование, пробная эксплуатация.
// Создать иерархию проекта, назначить на каждую фазу группу, в которой будет по 2 человека.
// Создать график сдачи работ по проекту согласно последовательности разработки.
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
                1. Разработка ТЗ
                2.Проектирование
                3.Кодирование
                4.Тестирование
                5.Пробная эксплуатация""");
        int phase = scanner.nextInt();
        group.setPhase(phases[phase - 1]);
    }

    public void printGroups() {
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    public void searchByFio(String fio) {
        for (Group group : groups) {
            if (group.getFirstWorker().getFio().equals(fio) || group.getSecondWorker().getFio().equals(fio)) {
                System.out.println(group);
            }
        }
    }

    public void searchByPhase(String phase) {
        for (Group group : groups) {
            if (group.getPhase().equals(phase)) {
                System.out.println(group);
            }
        }
    }

    public void searchByGroupName(String groupName) {
        for (Group group : groups) {
            if (group.getGroupName().equals(groupName)) {
                System.out.println(group);
            }
        }
    }

    public void searchByFioAndPhase(String fio, String phase) {
        for (Group group : groups) {
            if ((group.getFirstWorker().getFio().equals(fio) || group.getSecondWorker().getFio().equals(fio)) && group.getPhase().equals(phase)) {
                System.out.println(group);
            }
        }
    }

    public void searchByFioAndGroupName(String fio, String groupName) {
        for (Group group : groups) {
            if ((group.getFirstWorker().getFio().equals(fio) || group.getSecondWorker().getFio().equals(fio)) && group.getGroupName().equals(groupName)) {
                System.out.println(group);
            }
        }
    }

    public void searchByPhaseAndGroupName(String phase, String groupName) {
        for (Group group : groups) {
            if (group.getPhase().equals(phase) && group.getGroupName().equals(groupName)) {
                System.out.println(group);
            }
        }
    }

    //расписание сдачи работ по проекту согласно последовательности разработки
    public void schedule() {
        date = LocalDate.now();
        for (Group group : groups) {
            System.out.println(group.getPhase() + " - " + date);
            date = date.plusDays(7);
        }
    }

    public void setGroups() {
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Group();
            System.out.println("Введите название группы: ");
            groups[i].setGroupName("Группа " + scanner.next());
            System.out.println("Первый сотрудник: ");
            groups[i].setFirstWorker(new Worker());
            System.out.println("------------------");
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
        return "Project{" +
                "groups=" + Arrays.toString(groups) +
                ", date=" + date +
                '}';
    }
}
