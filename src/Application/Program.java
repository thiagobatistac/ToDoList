package Application;

import Entities.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Task> todolist = new ArrayList<>();

        String taskName;
        String option;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        do {
            System.out.println("Enter a task: ");
            taskName = input.nextLine();

            System.out.println("Enter the date and time for the task (dd/MM/yyyy HH:mm): ");
            String taskDate = input.nextLine();
            LocalDateTime taskDateTime = LocalDateTime.parse(taskDate, formatter);

            todolist.add(new Task(taskName, taskDateTime));

            System.out.println("Task added successfully! Do you want to add any other tasks? (yes/no): ");
            option = input.nextLine();
        } while (option.equalsIgnoreCase("yes"));

        System.out.println("Your To-Do List:");
        for (Task task : todolist) {
            System.out.println(task);
        }

        input.close();
    }
}
