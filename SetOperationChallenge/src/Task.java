enum Status {IN_QUEUE, ASSIGNED, IN_PROGRESS }
enum Priority {HIGH, MEDIUM, LOW }


public class Task implements Comparable<Task>{



    private String assignee;
    private String project;
    private String description;
    private Priority priority;
    private Status status;

    public Task(String assignee, String project, String description, Priority priority, Status status) {
        this.assignee = assignee;
        this.project = project;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public Task(String assignee, String project, String description, Priority priority) {
        this(assignee, project, description, priority,
                assignee == null ? Status.IN_QUEUE : Status.ASSIGNED);
    }

    public Task(String project, String description, Priority priority) {
        this(null, project, description, priority);
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(project, description, priority, assignee, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;
        return getProject().equals(task.getProject()) && getDescription().equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getProject().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    @Override
    public int compareTo(Task o) {

        int result = this.project.compareTo(o.project);
        if (result == 0){
            result = this.description.compareTo(o.description);

        } return result;
    }
}
