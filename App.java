import java.util.Scanner;


public class App {
    private static Scanner in = new Scanner(System.in);
    private static String command = "list";
    private static TodoList list = new TodoList();

    public static void main(String[] args) {
        while (!command.equals("x")) {
            System.out.println("Enter x to exit.\nPlease specify a command [list, add, mark, archive]: ");
            command = in.nextLine();
            handleCommand();
        }
    }

    private static void handleCommand() {
        if (command.equals("list")) {
            System.out.println(list.toString());
        }
        else if (command.equals("add")) {
            System.out.println("Add an item: "); // mógłbyś rozbić l.23 i zawrzeć to co pod elifem w odrębnej funkcji dla przejrzystości
            list.addNewItem(new TodoItem(in.nextLine()));
        }
        else if (command.equals("mark")) {
            System.out.println("Which one you want to mark: "); // mógłbyś zawrzeć linie 26-28 w 1 funkcji dla przejrzystości
            String index = in.nextLine();
            list.mark(index);
        }
        else if (command.equals("archive")) {
            list.archive();
        }
    }
}
