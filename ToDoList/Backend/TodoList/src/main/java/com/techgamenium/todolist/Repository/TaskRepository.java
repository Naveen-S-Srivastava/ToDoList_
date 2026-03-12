package com.techgamenium.todolist.Repository;


import com.techgamenium.todolist.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}