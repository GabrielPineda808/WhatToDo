package com.todo.WhatToDO.controller;

import com.todo.WhatToDO.model.Task;
import com.todo.WhatToDO.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/tasks")
@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.allTasks();
        model.addAttribute("tasks", tasks); // says addAttribute() is not a method of Model
        return "tasks";
    }
}
