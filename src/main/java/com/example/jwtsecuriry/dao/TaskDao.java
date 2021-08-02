package com.example.jwtsecuriry.dao;

import com.example.jwtsecuriry.bean.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task,Long> {

}
