package com.example.jwtsecuriry.service;

import com.example.jwtsecuriry.bean.AppRole;
import com.example.jwtsecuriry.bean.AppUser;

public interface AcountService {
    public AppRole saveRole(AppRole  role);
    public AppUser saveUser(AppUser user);
    public void addRoleToUser(String userName,String roleName);
    public  AppUser findUserByUsername(String userName);
}
