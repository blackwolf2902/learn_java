import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int taskId;

    public TaskManager() {
        tasks = new ArrayList<>();
        taskId = 1;
    }

    public void addTask(String title) {
        Task newTask = new Task(taskId, title);
        tasks.add(newTask);
        System.out.println("Task is added with the ID of :" + taskId);
        taskId++;
    }

    public void removeTask(int taskId) {
        boolean found = false;

        for (Task task : tasks) {
            if (task.getId() == taskId) {
                tasks.remove(task);
                found = true;
                System.out.println("Task with the ID " + taskId + " has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("Task not found !!!");
        }
    }

    public void markAsDone(int taskId) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.Done();
                System.out.println("Task " + taskId + " marked as completed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task not found !!!");
        }
    }

    public void displayAll() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour To-Do Lists: \n");
            for (Task task : tasks) {
                task.getDetails();
            }
        }
    }
}
