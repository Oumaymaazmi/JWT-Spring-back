package com.example.jwtsecuriry.service;

import com.example.jwtsecuriry.bean.AppRole;
import com.example.jwtsecuriry.bean.AppUser;
import com.example.jwtsecuriry.dao.RoleDao;
import com.example.jwtsecuriry.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AcountServiceImpl implements AcountService {
    @Autowired
    //pour enregi le passwor cripté
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDao appUserDao;
    @Autowired
    private RoleDao appRoleDao;

    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleDao.save(role);
    }

    @Override
    public AppUser saveUser(AppUser user) {
        if (!user.getPassword().equals(user.getRepassword()))
            throw new RuntimeException("You must confirm yout password ");
        if(appUserDao.findByUsername(user.getUsername())!=null)
            throw new RuntimeException("this user already exists ");
        String hashPC = bCryptPasswordEncoder.encode(user.getPassword());
        String hashPC2 = bCryptPasswordEncoder.encode(user.getRepassword());
        user.setPassword(hashPC);
        user.setRepassword(hashPC);
       // if(user.getRoles().size()==0) addRoleToUser(user.getUsername(),"USER");
        return appUserDao.save(user);

    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppRole r = appRoleDao.findByRolename(roleName);
        AppUser user = appUserDao.findByUsername(userName);
        user.getRoles().add(r);

    }

    @Override
    public AppUser findUserByUsername(String userName) {
        return appUserDao.findByUsername(userName);
    }
}
