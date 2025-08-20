package com.todo.WhatToDO.service;

import com.todo.WhatToDO.model.Task;
import com.todo.WhatToDO.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
}
