/**
 * Class representing a single todo item.
 *
 */
public class TodoItem{

    private String task;
    private boolean isDone;

    public TodoItem(String description) {
        this.task = description;
        this.isDone = false;
    }

    public void mark() {
        this.isDone = true;
    }

    public String getTask() {
        return this.task;
    }

    public boolean getIsDone() {
        return isDone;
    }
}
