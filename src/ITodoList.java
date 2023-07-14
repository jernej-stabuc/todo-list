public interface ITodoList {
    int getSize();
    void addTask(String description);
    Task getTask(int index);
}
