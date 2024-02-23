package lab4;

import lab4.project.Project;
import lab4.workers.Group;

public class Main {
    public static void main(String[] args) {
        Project project = new Project(new Group[5]);
        project.setGroups();
        project.schedule();
        System.out.println(project);

    }
}
