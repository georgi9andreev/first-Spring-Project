package com.excerciseallthings.excerciseallthings.service;

import com.excerciseallthings.excerciseallthings.Entity.Role;
import com.excerciseallthings.excerciseallthings.Entity.User;
import com.excerciseallthings.excerciseallthings.exception.DuplicateRecordException;
import com.excerciseallthings.excerciseallthings.exception.UserNotFoundException;
import com.excerciseallthings.excerciseallthings.reposotiry.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Data
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Set<User> findAll (){

        return new HashSet<>(userRepository.findAll());
    }

    public User save(User user) {
        //така винаги ще е CUSTOMER по default
        try {
            Role role = roleService.findByName("CUSTOMER");
            user.setRole(role);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword() ));
            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Username %s already exsist", user.getUsername())
            );
        }

    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with that ID not exsist"));
    }
}
