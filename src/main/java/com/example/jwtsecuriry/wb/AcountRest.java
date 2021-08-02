package com.example.jwtsecuriry.wb;

import com.example.jwtsecuriry.bean.AppUser;
import com.example.jwtsecuriry.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcountRest {
    @Autowired
    private AcountService acountService;

    @PostMapping("/register")
    public AppUser saveUser(@RequestBody  AppUser user ){
        return acountService.saveUser(user);


    }
}
