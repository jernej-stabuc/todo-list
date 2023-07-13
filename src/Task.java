import java.util.Objects;

public class Task {
    private String description;
    private boolean completed;
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }
    public boolean isCompleted() {
        return completed;
    }
    public String getDescription() {
        return description;
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
}
