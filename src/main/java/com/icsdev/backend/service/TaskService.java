package com.icsdev.backend.service;

import com.icsdev.backend.dto.TaskDTO;
import com.icsdev.backend.entity.Task;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface TaskService {
    
    List<Task> getAllTasks();

    Task createTask(TaskDTO taskDTO);

    ResponseEntity<String> deleteTask(Long id);

    Task getTaskByID(Long id);
}
