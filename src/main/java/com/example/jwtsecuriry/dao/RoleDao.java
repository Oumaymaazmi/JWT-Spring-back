package com.example.jwtsecuriry.dao;

import com.example.jwtsecuriry.bean.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<AppRole,Long> {
    public AppRole findByRolename(String rolename);

}
