/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npdi.demo.springmongo.resources;

import com.npdi.demo.springmongo.domain.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User christian = new User("1", "Christian", "christiano@milgrau.br");
        User joao = new User("2", "Joao", "joao@milgrau.br");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(christian, joao));
        return ResponseEntity.ok().body(list);
    }
}
