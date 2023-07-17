import java.util.Objects;

public class Task implements Comparable<Task> {
    private String description;
    private boolean completed;
    private Priority priority;
    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.priority = Priority.MEDIUM;
    }
    public boolean isCompleted() {
        return completed;
    }
    public String getDescription() {
        return description;
    }
    public Priority getPriority() {
        return priority;
    }
    public void markAsCompleted() {
        completed = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task other = (Task) obj;
        return Objects.equals(description, other.description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return this.description.compareTo(other.description);
    }
}
