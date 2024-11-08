package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String task;
    private LocalDateTime dateTime;

    public Task(String task, LocalDateTime dateTime) {
        this.task = task;
        this.dateTime = dateTime;
    }

    public String getTask() {
        return task;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Task: " + task + "| Date and Time: " + dateTime.format(formatter);
    }
}
