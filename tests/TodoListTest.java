import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;
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

    @Test
    public void testSortTasksByDescription() {
        TodoList todoList = new TodoList();
        todoList.addTask("Walk dog");
        todoList.addTask("Do laundry");
        todoList.addTask("Buy groceries");

        //sort by description
        todoList.sortTasksByDescription();

        assertEquals("Buy groceries", todoList.getTaskDescription(0));
        assertEquals("Do laundry", todoList.getTaskDescription(1));
        assertEquals("Walk dog", todoList.getTaskDescription(2));
    }
    @Test
    public void testSetAndGetPriority() {
        Task task = new Task("Task 1");

        //set the task priority
        task.setPriority(Priority.HIGH);

        //verify task priority
        assertEquals(Priority.HIGH, task.getPriority());
    }

    @Test
    public void testSetAndGetTaskDueDate() {
        Task task = new Task("Task 1");

        //Set the task due date
        //7 days from now
        LocalDate dueDate = LocalDate.now().plusDays(7);

        //verify the task due date
        task.setDueDate(dueDate);

        assertEquals(dueDate, task.getDueDate());
    }

    @Test
    public void testOverdueTask() {
        Task task = new Task("Task 1");

        //set the task due date to a past date
        LocalDate pastDate = LocalDate.now().minusDays(1);
        task.setDueDate(pastDate);

        Task task2 = new Task("Task 2");
        //Set the task due date
        //7 days from now
        LocalDate dueDate = LocalDate.now().plusDays(7);

        //verify the task due date
        task2.setDueDate(dueDate);

        //verify that the task is considered overdue
        assertTrue(task.isOverdue());
        assertFalse(task2.isOverdue());
    }

    @Test
    public void testSetAndGetTaskLabel() {
        Task task = new Task("Task 1");

        //set task label
        task.setLabel("Personal");

        //Verify the task label
        assertEquals("Personal", task.getLabel());
    }
    
    @Test
    public void testFilterTasksByDueDate() {
        // set due dates for tasks
        LocalDate today = LocalDate.now();
        todoList.getTask(0).setDueDate(today);
        todoList.getTask(1).setDueDate(today.plusDays(1));
        todoList.getTask(2).setDueDate(today.plusDays(2));
        
        // filter tasks by due date
        List<Task> filteredTasks = todoList.filterByDueDate(today);

        assertEquals(1, filteredTasks.size());
        assertTrue(filteredTasks.contains(todoList.getTask(0)));
    }

    @Test
    public void testFilterByPriority() {
        todoList.getTask(1).setPriority(Priority.HIGH);
        todoList.getTask(2).setPriority(Priority.HIGH);

        List<Task> filteredTasks = todoList.filterByPriority(Priority.HIGH);

        assertEquals(2, filteredTasks.size());
        assertTrue(filteredTasks.contains(todoList.getTask(1)));
        assertTrue(filteredTasks.contains(todoList.getTask(2)));
    }

    @Test
    public void testFilterByLabel() {
        todoList.getTask(0).setLabel("Work");
        todoList.getTask(1).setLabel("work");

        List<Task> filteredTasks = todoList.filterByLabel("Work");

        assertEquals(2, filteredTasks.size());
        assertTrue(filteredTasks.contains(todoList.getTask(0)));
        assertTrue(filteredTasks.contains(todoList.getTask(1)));
    }

    @Test
    public void testFilterByCompletionStatus() {
        todoList.getTask(0).markAsCompleted();
        todoList.getTask(1).markAsCompleted();

        List<Task> filteredTasks = todoList.filterByCompletion(true);

        assertEquals(2, filteredTasks.size());
        assertTrue(filteredTasks.contains(todoList.getTask(0)));
        assertTrue(filteredTasks.contains(todoList.getTask(1)));
    }
}
