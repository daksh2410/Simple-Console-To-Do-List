import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to your To-Do List!");

        do {
            // Print the menu
            System.out.println("\n--- Menu ---");
            System.out.println("1. View tasks");
            System.out.println("2. Add a task");
            System.out.println("3. Mark task as complete");
            System.out.println("4. Delete a task");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline character

            switch (choice) {
                case 1:
                    viewTasks(tasks);
                    break;
                case 2:
                    addTask(tasks, scanner);
                    break;
                case 3:
                    markTaskComplete(tasks, scanner);
                    break;
                case 4:
                    deleteTask(tasks, scanner);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void viewTasks(ArrayList<Task> tasks) {
        System.out.println("\n--- Your Tasks ---");
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void addTask(ArrayList<Task> tasks, Scanner scanner) {
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    private static void markTaskComplete(ArrayList<Task> tasks, Scanner scanner) {
        viewTasks(tasks);
        if (tasks.isEmpty()) return;
        
        System.out.print("Enter the number of the task to mark as complete: ");
        int taskNumber = scanner.nextInt() - 1;

        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.get(taskNumber).markAsCompleted();
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask(ArrayList<Task> tasks, Scanner scanner) {
        viewTasks(tasks);
        if (tasks.isEmpty()) return;

        System.out.print("Enter the number of the task to delete: ");
        int taskNumber = scanner.nextInt() - 1;

        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.remove(taskNumber);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}