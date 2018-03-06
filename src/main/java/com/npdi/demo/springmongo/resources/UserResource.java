/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npdi.demo.springmongo.resources;

import com.npdi.demo.springmongo.domain.User;
import com.npdi.demo.springmongo.dto.UserDTO;
import com.npdi.demo.springmongo.services.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream()
                                    .map(x -> new UserDTO(x))
                                    .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }
}
