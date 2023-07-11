import org.junit.Assert;
import org.junit.Test;
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
        assertFalse(todoList.isTaskCompleted(0));
        assertTrue(todoList.isTaskCompleted(1));
    }
    @Test
    public void testIsTaskCompleted() {
        TodoList todoList = new TodoList();
        todoList.addTask("Buy groceries");
        todoList.addTask("Do laundry");
        assertFalse(todoList.isTaskCompleted(0));
        assertFalse(todoList.isTaskCompleted(1));
    }


}
