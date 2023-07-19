import java.time.LocalDate;
import java.util.Objects;

public class Task implements Comparable<Task> {
    private String description;
    private boolean completed;
    private Priority priority;
    private LocalDate dueDate;
    private String label;
    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.priority = Priority.MEDIUM;
        this.dueDate = null;
        this.label = null;
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

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
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

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        return dueDate != null && dueDate.isBefore(today);
    }
}
