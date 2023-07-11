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
        todoList.addTask("    Buy groceries           ");
        assertEquals(1, todoList.getSize());
        assertEquals("Buy groceries", todoList.getTask(0).getDescription());
    }

}
