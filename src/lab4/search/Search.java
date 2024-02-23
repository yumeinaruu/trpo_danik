package lab4.search;

import lab4.Main;
import lab4.project.Project;
import lab4.workers.Group;

public class Search {


    public void printGroups(Project project) {
        for (Group group : project.getGroups()) {
            System.out.print(group);
        }
        System.out.println("------------------");
    }

    public void searchByFio(String fio, Project project) {
        for (Group group : project.getGroups()) {
            if (group.getFirstWorker().getFio().equals(fio) || group.getSecondWorker().getFio().equals(fio)) {
                System.out.println(group);
            }
        }
    }

    public void searchByPhase(String phase, Project project) {
        for (Group group : project.getGroups()) {
            if (group.getPhase().equals(phase)) {
                System.out.println(group);
            }
        }
    }

    public void searchByGroupName(String groupName, Project project) {
        for (Group group : project.getGroups()) {
            if (group.getGroupName().equals(groupName)) {
                System.out.println(group);
            }
        }
    }

    public void searchByFioAndPhase(String fio, String phase, Project project) {
        for (Group group : project.getGroups()) {
            if ((group.getFirstWorker().getFio().equals(fio) || group.getSecondWorker().getFio().equals(fio)) && group.getPhase().equals(phase)) {
                System.out.println(group);
            }
        }
    }

    public void searchByFioAndGroupName(String fio, String groupName, Project project) {
        for (Group group : project.getGroups()) {
            if ((group.getFirstWorker().getFio().equals(fio) || group.getSecondWorker().getFio().equals(fio)) && group.getGroupName().equals(groupName)) {
                System.out.println(group);
            }
        }
    }

    public void searchByPhaseAndGroupName(String phase, String groupName, Project project) {
        for (Group group : project.getGroups()) {
            if (group.getPhase().equals(phase) && group.getGroupName().equals(groupName)) {
                System.out.println(group);
            }
        }
    }
}
