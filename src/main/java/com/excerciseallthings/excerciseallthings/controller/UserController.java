package com.excerciseallthings.excerciseallthings.controller;

import com.excerciseallthings.excerciseallthings.Entity.User;
import com.excerciseallthings.excerciseallthings.converter.UserConverter;
import com.excerciseallthings.excerciseallthings.dto.user.UserResponse;
import com.excerciseallthings.excerciseallthings.dto.user.UserSaveRequest;
import com.excerciseallthings.excerciseallthings.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;


@AllArgsConstructor
@Builder
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
  private final UserConverter userConverter;

//    public UserController(UserService userService, UserConverter userConverter){
//
//        this.userService = userService;
//       // this.userConverter = userConverter;
//        this.userConverter = userConverter;
//    }

    @GetMapping
    public ResponseEntity<Set<UserResponse>> findAll (){
        return ResponseEntity.ok(userService.findAll()
                .stream()
                .map(userConverter::convert)
                .collect(Collectors.toSet())
        );
    }

    @PostMapping
    public ResponseEntity<UserResponse> save (@RequestBody @Valid UserSaveRequest userSaveRequest){

        User user = userConverter.convert(userSaveRequest);
        User savedUser = userService.save (user);
        UserResponse userResponse = userConverter.convert(savedUser);

//        // Трябва UserSaveRequest-а да го конвертираме в user и за това си създаваме UserConverter
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);

    }



}
