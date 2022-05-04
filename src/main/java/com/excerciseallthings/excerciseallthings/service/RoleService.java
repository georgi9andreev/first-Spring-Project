package com.excerciseallthings.excerciseallthings.service;

import com.excerciseallthings.excerciseallthings.Entity.Role;
import com.excerciseallthings.excerciseallthings.exception.DuplicateRecordException;
import com.excerciseallthings.excerciseallthings.exception.RecordNotFoundException;
import com.excerciseallthings.excerciseallthings.reposotiry.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Data
@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;


    public Set<Role> findAll (){

        return new HashSet<>(roleRepository.findAll());
    }

    public Role findByName (String name){
        return roleRepository.findByName(name)
                .orElseThrow(()-> new RecordNotFoundException(
                        String.format ("Role %s not found", name)
                ));
    }

    public Role findById (Long id){
        return roleRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException(
                        String.format ("Role with id %s not found", id)
                ));
    }

    public Role update (Role updatedRole, @NonNull Long id){
       Role dbRole = findById(id);
       dbRole.setName(updatedRole.getName());
        return save(dbRole);

    }

    public Role save (Role role){
        try{
            return roleRepository.save(role);
        }catch (DataIntegrityViolationException ex){
                throw new DuplicateRecordException(
                        String.format("Role name %s already exsist", role.getName())
                );
        }
    }

    public void delete (Long id){
        roleRepository.deleteById(id);
    }

    public void delete (String name){
        roleRepository.deleteByName(name);
    }
}
