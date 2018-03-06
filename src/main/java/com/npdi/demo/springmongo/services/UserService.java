/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npdi.demo.springmongo.services;

import com.npdi.demo.springmongo.domain.User;
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
}
