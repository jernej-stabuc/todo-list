import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class TodoListTest {
    private TodoList todoList;

    @Before
    public void setup() {
        todoList = new TodoList();

        todoList.addTask("Buy groceries");
        todoList.addTask("Do laundry");
        todoList.addTask("Walk dog");
    }
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
    public void testClearTasks() {
        todoList.clearTasks();
        assertEquals(0, todoList.getSize());
        assertTrue(todoList.isEmpty());
    }
    @Test
    public void testAddTask() {
        TodoList todoList = new TodoList();
        todoList.addTask("   Buy groceries   ");
        assertEquals(1, todoList.getSize());
        assertEquals("Buy groceries", todoList.getTaskDescription(0));
    }

    @Test
    public void testMarkTaskAsCompleted() {
        todoList.markTaskAsCompleted(1);
        List<Task> completedTasks = todoList.getCompletedTasks();
        assertFalse(todoList.isTaskCompleted(0));
        assertTrue(completedTasks.contains(new Task("Do laundry")));
    }
    @Test
    public void testIsTaskCompleted() {
        assertFalse(todoList.isTaskCompleted(0));
        assertFalse(todoList.isTaskCompleted(1));
    }
    @Test
    public void testGetCompletedTasks() {
        // Mark tasks as completed
        todoList.markTaskAsCompleted(0);
        todoList.markTaskAsCompleted(1);
        todoList.markTaskAsCompleted(2);
        // Retrieve completed tasks
        List<Task> completedTasks = todoList.getCompletedTasks();

        // Assert the size of the completed tasks list
        assertEquals(2, completedTasks.size());

        // Assert the specific completed tasks
        assertTrue(completedTasks.contains(new Task("Buy groceries")));
        assertTrue(completedTasks.contains(new Task("Walk dog")));
    }
    @Test
    public void testEditTaskDescription() {
        todoList.editTaskDescription(1, "Clean entire house");
        assertEquals("Clean entire house", todoList.getTaskDescription(1));
    }

}
