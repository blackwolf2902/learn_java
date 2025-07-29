import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n=====To-Do List Menu=====\n");
            System.out.println("1. Add a new Task\n");
            System.out.println("2. Remove a Task\n");
            System.out.println("3. Mark a Task as Done\n");
            System.out.println("4. View all Tasks.\n");
            System.out.println("5. Quit.\n");
            System.out.println("Enter the option from above : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the title :");
                    String title = sc.nextLine();
                    manager.addTask(title);
                    break;
                case 2:
                    System.out.println("Enter the Id to remove: ");
                    int id = sc.nextInt();
                    manager.removeTask(id);
                    break;
                case 3:
                    System.out.println("Enter the task ID to mark as done : ");
                    int t_id = sc.nextInt();
                    manager.markAsDone(t_id);
                    break;
                case 4:
                    manager.displayAll();
                    break;
                case 5:
                    System.out.println("Exiting...GoodBye !!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option.");
            }
        }
    }
}
