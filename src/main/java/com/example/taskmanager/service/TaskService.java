package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTaskById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(int id, Task updatedTask) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
        }
    }

    public void deleteTask(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }
}
