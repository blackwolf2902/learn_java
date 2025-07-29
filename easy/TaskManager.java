import java.util.*;
import java.io.*;


public class TaskManager {
    private ArrayList<Task> tasks;
    private final String FILE_NAME = "tasks.txt";

    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasksFromFile();
    }

    public void addTask(String title) {
        Task newTask = new Task(title);
        tasks.add(newTask);
        saveTaskToFile();
        System.out.println("Task is added.");
    }

    public void removeTask(int taskId) {
        tasks.removeIf(t -> t.getId() == taskId);
        saveTaskToFile();
        System.out.println("Task removed.");
    }

    public void markAsDone(int taskId) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.Done();
                saveTaskToFile();
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

    public void saveTaskToFile(){
        try(FileWriter fw = new FileWriter(FILE_NAME)){
            for(Task task:tasks){
                fw.write(task.toFileString()+"\n");
            }
        }catch(IOException e){
            System.out.println("Error saving tasks: "+e.getMessage());
        }
    }
    private void loadTasksFromFile(){
        File file = new File(FILE_NAME);

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 3){
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    boolean isDone = Boolean.parseBoolean(parts[2]);
                    Task t = new Task(id, title, isDone);
                    tasks.add(t);
                }
            }
            System.out.println("Tasks Loaded from saved file");
        }catch(IOException e){
            System.out.println("Error loading tasks: "+e.getMessage());
        }
    }
}
