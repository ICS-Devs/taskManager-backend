package com.icsdev.backend.repositoryDao;

import com.icsdev.backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface TaskRepository extends JpaRepository<Task, Long> {
}
