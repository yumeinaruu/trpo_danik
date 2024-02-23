package lab4;

public class Main {
    public static void main(String[] args) {
        Project project = new Project(new Group[5]);
        project.setGroups();
        project.schedule();
        System.out.println(project.toString());
    }
}
