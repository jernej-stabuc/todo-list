import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }
    public int getSize() {
        return tasks.size();
    }
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            return;
        }
        Task task = new Task(description.trim());
        tasks.add(task);
    }

    public boolean isEmpty() {
        return tasks == null || tasks.isEmpty();
    }
    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }
        return null;
    }
}
