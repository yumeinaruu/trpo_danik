package lab4.workers;

public class Group {
    private String groupName;
    private Worker firstWorker;
    private Worker secondWorker;
    private String phase;

    public Group(String groupName, Worker firstWorker, Worker secondWorker, String phase) {
        this.groupName = groupName;
        this.firstWorker = firstWorker;
        this.secondWorker = secondWorker;
        this.phase = phase;
    }

    public Group() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Worker getFirstWorker() {
        return firstWorker;
    }

    public void setFirstWorker(Worker firstWorker) {
        this.firstWorker = firstWorker;
    }

    public Worker getSecondWorker() {
        return secondWorker;
    }

    public void setSecondWorker(Worker secondWorker) {
        this.secondWorker = secondWorker;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Override
    public String toString() {
        return "Название группы: " + groupName+
                firstWorker +
                secondWorker +
                " | Фаза: " + phase + "\n";
    }
}
