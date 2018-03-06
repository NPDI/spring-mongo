/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npdi.demo.springmongo.config;

import com.npdi.demo.springmongo.domain.User;
import com.npdi.demo.springmongo.repository.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {

        userRepo.deleteAll();

        User diego = new User(null, "Dulval", "diegodulval@npdi.br");
        User cris = new User(null, "Christian", "christian@npdi.br");
        User jp = new User(null, "Joao Pedro", "joaopedro@npdi.br");

        userRepo.saveAll(Arrays.asList(diego, cris, jp));
    }

}
