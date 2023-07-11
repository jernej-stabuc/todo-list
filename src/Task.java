public class Task {
    private String description;
    private boolean completed;
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }
    public String getDescription() {
        return description;
    }
    public void markAsCompleted() {
        completed = true;
    }
}
