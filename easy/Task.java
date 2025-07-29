public class Task {
    private int id;
    private String title;
    private boolean isDone;

    public Task(int id, String title) {
        this.id = id;
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
}
