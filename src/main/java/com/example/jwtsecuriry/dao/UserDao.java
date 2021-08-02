package com.example.jwtsecuriry.dao;

import com.example.jwtsecuriry.bean.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<AppUser, Long> {
    public AppUser findByUsername(String username);

}
