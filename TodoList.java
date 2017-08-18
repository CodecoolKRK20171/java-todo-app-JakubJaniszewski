import java.util.ArrayList;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.IndexOutOfBoundsException;
import java.lang.NumberFormatException;



public class TodoList{
    private ArrayList<TodoItem>  todoItems = new ArrayList<>();

    public TodoList() {
    }

    public void mark(String index) {
        try {
            Integer i = Integer.parseInt(index) - 1;
            (todoItems.get(i)).mark();
        } catch (IndexOutOfBoundsException|NumberFormatException e) {
        }
    }

    public void archive() {
        for (int i=0; i<todoItems.size(); i++) {
            try {
                if (todoItems.get(i).getIsDone()) {
                todoItems.remove(todoItems.get(i));
                }
            } catch(ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    public String toString() {
        System.out.println("You saved the following to-do items:\n");
        String result = "";

        for (Integer i=0; i<todoItems.size(); i++) {
            result += getOneLine(i);
        }

        return result;
    }

    private String getOneLine(Integer i) {
        String line = Integer.toString(i + 1) + ". ";

        if ((todoItems.get(i).getIsDone())) {
            line += "[x] ";
        }
        else {
            line += "[ ] ";
        }

        line += (todoItems.get(i)).getTask();

        return line;
    }

    public void addNewItem(TodoItem item) {
        todoItems.add(item);
    }
}
