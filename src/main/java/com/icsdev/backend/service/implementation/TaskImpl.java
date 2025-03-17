package com.icsdev.backend.service.implementation;

import com.icsdev.backend.dto.TaskDTO;
import com.icsdev.backend.entity.Task;
import com.icsdev.backend.exception.TaskNotFoundException;
import com.icsdev.backend.repositoryDao.TaskRepository;
import com.icsdev.backend.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class TaskImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskImpl(TaskRepository taskRepository) {
        
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    @Override
    public Task createTask(TaskDTO taskDTO) {

        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.isCompleted());
        return taskRepository.save(task);
    }

    @Override
    public ResponseEntity<String> deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }

        taskRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted task with id " + id + " properly");
    }

    @Override
    public Task getTaskByID(Long id) {
        return taskRepository.findById(id).
        orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
    }
}
