package com.excerciseallthings.excerciseallthings.starter;

import com.excerciseallthings.excerciseallthings.Entity.Role;
import com.excerciseallthings.excerciseallthings.Entity.User;
import com.excerciseallthings.excerciseallthings.service.RoleService;
import com.excerciseallthings.excerciseallthings.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class DemoStarter implements CommandLineRunner {
    private final RoleService roleService;
    private final UserService userService;


    @Override
    public void run(String... args) throws Exception {
//        Role firstRole = new Role();
//        firstRole.setName("ADMIN");
//        Role secondRole = new Role();
//        secondRole.setName("CUSTOMERR");
//        roleService.save(firstRole);
//        roleService.save(secondRole);
//        Role updatedRole = new Role();
//        updatedRole.setName("UPDATED_CUSTOMER");
//        roleService.update(updatedRole, secondRole.getId());
//
//        User user = new User();
//        user.setFullName("Georgi Andreev");
//        user.setPassword("12345");
//        user.setUcn("900506");
//
//        userService.save(user);

    }
}
