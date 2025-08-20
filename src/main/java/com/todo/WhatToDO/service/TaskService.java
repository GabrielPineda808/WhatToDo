package com.todo.WhatToDO.service;

import com.todo.WhatToDO.model.Task;
import com.todo.WhatToDO.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> allTasks(){
        return new ArrayList<>(taskRepository.findAll());
    }

    public void createTask(String title){
        Task task = new Task();
        task.setCompleted(false);
        task.setTitle(title);
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void toggleTask (Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Task ID"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
