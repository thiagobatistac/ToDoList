package Application;

import Entities.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Task> todolist = new ArrayList<>();

        String taskName;
        String option;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try {

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
            List<String> sortedList = todolist.stream()
                    .sorted(Comparator.comparing(Task::getDateTime))
                    .map(td -> td.getTask() + " - " + td.getDateTime().format(formatter))
                    .collect(Collectors.toList());

            sortedList.forEach(System.out::println);

        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date/time format. Please use the format dd/MM/yyyy HH:mm.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        input.close();
    }
}