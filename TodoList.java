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

    public void archive() { //operujesz na funkcji po której iterujesz, nie zadziała poprawnie.
        for (int i=0; i<todoItems.size(); i++) {
            try {
                if (todoItems.get(i).getIsDone()) {
                todoItems.remove(todoItems.get(i));
                }
            } catch(ArrayIndexOutOfBoundsException e) { // catch niepotrzebny, jeśli stworzysz pomocniczą listę w której przechowasz indexy do usunięcia
            }
        }
    }

    public String toString() { // metodę toString przeniósłbym do klasy TodoItems
        System.out.println("You saved the following to-do items:\n");
        String result = "";

        for (Integer i=0; i<todoItems.size(); i++) {
            result += getOneLine(i); // tu brakuje \newline pomiędzy poszczególnymi getOneLine(i), taski wyświetlają się w 1 linii
        }

        return result;
    }

    private String getOneLine(Integer i) { // tą funkcję zamieniłbym właśnie na metodę toString objektu TodoItem
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
