import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> tasks;
    private List<Task> completed;

    public TodoList() {
        tasks = new ArrayList<>();
        completed = new ArrayList<>();
    }

    //change method refactor
    public int getSize() {
        if (!completed.isEmpty()) {
            return completed.size();
        }
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
    public boolean isTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            return task.isCompleted();
        }
        return false;
    }
    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
        }
    }
    public void moveTasksToCompleted() {
        for (Task task : tasks) {
            if (task.isCompleted()) {
                tasks.remove(task);
                completed.add(task);
            }
        }
    }
}
