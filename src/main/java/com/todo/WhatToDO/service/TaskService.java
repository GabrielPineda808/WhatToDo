package com.todo.WhatToDO.service;

import com.todo.WhatToDO.model.Task;
import com.todo.WhatToDO.repository.TaskRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public List<Task> allTasks(){
        return new ArrayList<>(taskRepository.findAll());
    }
}
