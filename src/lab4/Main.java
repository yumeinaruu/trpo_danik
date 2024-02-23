package lab4;

import lab4.project.Project;
import lab4.search.Search;
import lab4.workers.Group;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Project project = new Project(new Group[5]);
        Search search = new Search();

        project.setGroups();
        project.schedule();
        search.printGroups(project);

        System.out.println("Введите ФИО работника: ");
        search.searchByFio(scanner.nextLine(), project);

        System.out.println("Введите группу: ");
        search.searchByGroupName(scanner.nextLine(), project);

        System.out.println("Введите фазу: ");
        search.searchByPhase(scanner.nextLine(), project);
    }
}
