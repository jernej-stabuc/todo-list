import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class TodoListTest {

    @Test
    public void testEmptyList() {
        TodoList emptyList = new TodoList();
        assertEquals(0, emptyList.getSize());
    }
    @Test
    public void testIsEmpty() {
        TodoList todoList = new TodoList();
        todoList.addTask("");
        assertTrue(todoList.isEmpty());
        todoList.addTask("Visit mother");
        assertFalse(todoList.isEmpty());
    }
    @Test
    public void testAddTask() {
        TodoList todoList = new TodoList();
        todoList.addTask("   Buy groceries   ");
        Task firstTask = todoList.getTask(0);
        assertEquals(1, todoList.getSize());
        assertEquals("Buy groceries", firstTask.getDescription());
    }

    @Test
    public void testMarkTaskAsCompleted() {
        TodoList todoList = new TodoList();
        todoList.addTask("Buy groceries");
        todoList.addTask("Do laundry");

        todoList.markTaskAsCompleted(1);
        List<Task> completedTasks = todoList.getCompletedTasks();
        assertFalse(todoList.isTaskCompleted(0));
        assertTrue(completedTasks.contains(new Task("Do laundry")));
    }
    @Test
    public void testIsTaskCompleted() {
        TodoList todoList = new TodoList();
        todoList.addTask("Buy groceries");
        todoList.addTask("Do laundry");
        assertFalse(todoList.isTaskCompleted(0));
        assertFalse(todoList.isTaskCompleted(1));
    }
    @Test
    public void testGetCompletedTasks() {
        TodoList todoList = new TodoList();
        todoList.addTask("Task 1");
        todoList.addTask("Task 2");
        todoList.addTask("Task 3");

        // Mark tasks as completed
        todoList.markTaskAsCompleted(0);
        todoList.markTaskAsCompleted(1);

        // Retrieve completed tasks
        List<Task> completedTasks = todoList.getCompletedTasks();

        // Assert the size of the completed tasks list
        assertEquals(2, completedTasks.size());

        // Assert the specific completed tasks
        assertTrue(completedTasks.contains(new Task("Task 1")));
        assertTrue(completedTasks.contains(new Task("Task 3")));
    }

}
