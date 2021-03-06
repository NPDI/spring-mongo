/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npdi.demo.springmongo.services;

import com.npdi.demo.springmongo.domain.User;
import com.npdi.demo.springmongo.dto.UserDTO;
import com.npdi.demo.springmongo.repository.UserRepository;
import com.npdi.demo.springmongo.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;
    
    public List<User> findAll() {
        return repo.findAll();
    }
    
    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        if (!user.isPresent()) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user.get();
    }
    
    public User insert(User obj) {
        return repo.insert(obj);
    }
    
    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }
    
    public User update(User obj) {
        User newObj = findById(obj.getId());
        
        updateData(newObj, obj);
        return repo.save(newObj);
    }
    
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
    
    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
