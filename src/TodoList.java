import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class TodoList implements ITodoList {
    private List<Task> tasks;
    private List<Task> completed;

    public TodoList() {
        tasks = new ArrayList<>();
        completed = new ArrayList<>();
    }
    public List<Task> getCompletedTasks() {
        return new ArrayList<>(completed);
    }
    public int getSize() {
        return tasks.size() + completed.size();
    }

    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            return;
        }
        Task task = new Task(description.trim());
        tasks.add(task);
    }

    public boolean isEmpty() {
        return tasks.isEmpty() && completed.isEmpty();
    }
    public void clearTasks() {
        tasks.clear();
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
    public Task getTask(int index) {
        if (isValidIndex(index)) {
            return tasks.get(index);
        }
        return null;
    }
    public boolean isTaskCompleted(int index) {
        if (isValidIndex(index)) {
            Task task = tasks.get(index);
            return task.isCompleted();
        }
        return false;
    }
    public void markTaskAsCompleted(int index) {
        if (isValidIndex(index)) {
            Task task = tasks.get(index);
            task.markAsCompleted();
            tasks.remove(index);
            completed.add(task);
        }
    }
    public void editTaskDescription(int index, String newDescription) {
        if (isValidIndex(index)) {
            Task task = tasks.get(index);
            task.setDescription(newDescription);
        }
    }
    public String getTaskDescription(int index) {
        if (isValidIndex(index)) {
            Task task = tasks.get(index);
            return task.getDescription();
        }
        return null;
    }
    public void sortTasksByDescription() {
        Collections.sort(tasks);
    }

    public List<Task> filterByDueDate(LocalDate dueDate) {
        return filterTasks(task -> task.getDueDate() != null && task.getDueDate().isEqual(dueDate));
    }

    public List<Task> filterByPriority(Priority priority) {
        return filterTasks(task -> task.getPriority() == priority);
    }

    public List<Task> filterByLabel(String label) {
        return filterTasks(task -> label.equalsIgnoreCase(task.getLabel()));
    }

    public List<Task> filterByCompletion(Boolean completed) {
        return filterTasks(task -> task.isCompleted() == completed);
    }

    public List<Task> filterTasks(Predicate<Task> predicate) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task: tasks) {
            if (predicate.test(task)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
}
