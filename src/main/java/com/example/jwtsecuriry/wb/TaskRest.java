package com.example.jwtsecuriry.wb;

import com.example.jwtsecuriry.bean.Task;
import com.example.jwtsecuriry.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskRest {
    @Autowired
    private TaskDao taskDao;

    @GetMapping("/tasks")
    public List<Task> findAll(){
        return taskDao.findAll();
    }

    @PostMapping("/tasks")
    public Task save(@RequestBody  Task task){
        return taskDao.save(task);
    }
}
