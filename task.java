public class task {
    private String description;
    private boolean isCompleted;

    // Constructor to create a new task
    public Task(String description) {
        this.description = description;
        this.isCompleted = false; // New tasks are always pending
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Getter for the completion status
    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to mark the task as complete
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // A nice way to display the task as a string
    @Override
    public String toString() {
        String status = isCompleted ? "[X]" : "[ ]";
        return status + " " + description;
    }
}