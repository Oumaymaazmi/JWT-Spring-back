package com.example.jwtsecuriry;

import com.example.jwtsecuriry.bean.AppRole;
import com.example.jwtsecuriry.bean.AppUser;
import com.example.jwtsecuriry.bean.Task;
import com.example.jwtsecuriry.dao.TaskDao;
import com.example.jwtsecuriry.dao.UserDao;
import com.example.jwtsecuriry.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class JwtSecuriryApplication implements CommandLineRunner {


    @Autowired
    private TaskDao taskDao;
    @Autowired
    private AcountService acountService;
    @Autowired
    private UserDao userDao;
    public static void main(String[] args) {
        SpringApplication.run(JwtSecuriryApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public void run(String... args) throws Exception {
        acountService.saveUser(new AppUser(null,"admin","1234","1234",null));
        acountService.saveUser(new AppUser(null,"user","1234","1234",null));
        acountService.saveRole(new AppRole(null,"ADMIN"));
        acountService.saveRole(new AppRole(null,"USER"));
        acountService.addRoleToUser("admin","ADMIN");
        acountService.addRoleToUser("admin","USER");
        acountService.addRoleToUser("user","USER");

        System.out.println(userDao.findAll());
        Stream.of("t1","t2","t3").forEach(ta -> {
            taskDao.save(new Task(null,ta));
        });
        taskDao.findAll().forEach(t->{
            System.out.println(t.getNom());
        });

    }
}
