public class Task {
    private static int counter =1;
    private int id;
    private String title;
    private boolean isDone;

    public Task(int id, String title,boolean isDone) {
        this.id = id;
        this.title = title;
        this.isDone = isDone;
        counter = Math.max(counter, id +1);
    }

    public Task(String title){
        this.id = counter++;
        this.title = title;
        this.isDone = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isDone;
    }

    public void Done() {
        this.isDone = true;
    }

    public void getDetails() {
        System.out.println((isDone ? "[X] " : "[] ") + id + ": " + title + "\n");
    }

    public String toFileString(){
        return id+","+title+","+isDone;
    }

    public static Task fromFileString(String line){
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0]);
        String title = parts[1];
        boolean done = Boolean.parseBoolean(parts[2]);
        return new Task(id,title,done);
    }
}
