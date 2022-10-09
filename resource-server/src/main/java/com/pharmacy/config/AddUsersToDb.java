package com.pharmacy.config;

import com.pharmacy.config.permission.Permission;
import com.pharmacy.model.User;
import com.pharmacy.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AddUsersToDb implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
//        User user1 = new User();
//        user1.setEmail("user1@email.com");
//        user1.setName("USER1");
//        user1.setRole(Permission.CUSTOMER.toString());
//        user1.setPassword("user1");
//        userService.createAdminUser(user1);
//
//        User user2 = new User();
//        user2.setEmail("user2@email.com");
//        user2.setName("USER2");
//        user2.setRole(Permission.CUSTOMER.toString());
//        user2.setPassword("user2");
//        userService.createAdminUser(user2);
    }
}
