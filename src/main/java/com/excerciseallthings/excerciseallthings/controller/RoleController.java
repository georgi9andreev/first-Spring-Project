package com.excerciseallthings.excerciseallthings.controller;


import com.excerciseallthings.excerciseallthings.Entity.Role;
import com.excerciseallthings.excerciseallthings.converter.RoleConverter;
import com.excerciseallthings.excerciseallthings.dto.role.RoleResponse;
import com.excerciseallthings.excerciseallthings.dto.role.RoleSaveRequest;
import com.excerciseallthings.excerciseallthings.dto.role.RoleUpdateRequest;
import com.excerciseallthings.excerciseallthings.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/roles")
public class RoleController {

    private final RoleService roleService;
    private final RoleConverter roleConverter;

// Заради @RequestMapping(value = "/roles") ако искаме да достъпим
    // това пишем:  localhost:8080/roles/roles

    @GetMapping
    // Responseentity ни дава да видим данните в json примерно
    // и ни дава и да казваме какъв ще е респонса
    public ResponseEntity<Set<RoleResponse>> findAll (){
//        for(Role role: roles){
//            roleResponses.add(roleConverter.convert(role));
//        }
        //stream-a е ввместо фор лууп
        return ResponseEntity.ok(roleService.findAll()
                .stream()
                .map(role -> roleConverter.convert(role))
                .collect(Collectors.toSet()));
    }
    // пишем:  localhost:8080/roles/roles/save
    @PostMapping
    public ResponseEntity<RoleResponse> save (@RequestBody @Valid RoleSaveRequest roleSaveRequest) {
        //За да не се пише едно и също много пъти се правят converter-ите
        Role role = roleConverter.convert(roleSaveRequest);
        Role savedRole = roleService.save(role);
        RoleResponse response = roleConverter.convert(savedRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
// update
    @PutMapping
// @RequestBody намапва обекта, който подаваме в ПостМан-а към RoleUpdateRequest
    // За да сработят @NotNull анутациите *на ниво контролер* в RoleUpdateRequest тук трябда да добавим @Valid
    public ResponseEntity<RoleResponse> update(@RequestBody @Valid RoleUpdateRequest roleUpdateRequest){

        Role role = roleConverter.convert(roleUpdateRequest);
        Role updatedRole = roleService.update(role,role.getId());
        return ResponseEntity.ok(roleConverter.convert(updatedRole));

    }

    @DeleteMapping(value = "/{id}")
    //@PathVariable е за да ни намапне от {id} към id-to в скобите

    public ResponseEntity<HttpStatus> deleteById (@PathVariable Long id){
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/name /{name}")
    public ResponseEntity<HttpStatus> deleteById (@PathVariable String name) {
        roleService.delete(name);
        return ResponseEntity.ok().build();
    }
}
