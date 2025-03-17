package com.icsdev.backend.controller;

import com.icsdev.backend.dto.TaskDTO;
import com.icsdev.backend.entity.Task;
import com.icsdev.backend.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController 
@RequestMapping("/tasks") 
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskByID(@PathVariable Long id){
        Task task = taskService.getTaskByID(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        Task task = taskService.getTaskByID(id);
        return ResponseEntity.ok(task);
    }
}
