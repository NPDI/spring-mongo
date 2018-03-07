/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npdi.demo.springmongo.config;

import com.npdi.demo.springmongo.domain.Post;
import com.npdi.demo.springmongo.domain.User;
import com.npdi.demo.springmongo.dto.AuthorDTO;
import com.npdi.demo.springmongo.dto.CommentDTO;
import com.npdi.demo.springmongo.repository.PostRepository;
import com.npdi.demo.springmongo.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepo.deleteAll();
        userRepo.deleteAll();

        User diego = new User(null, "Dulval", "diegodulval@npdi.br");
        User cris = new User(null, "Christian", "christian@npdi.br");
        User jp = new User(null, "Joao Pedro", "joaopedro@npdi.br");
        userRepo.saveAll(Arrays.asList(diego, cris, jp));

        Post post1 = new Post(null, sdf.parse("20/02/2018"), "Partiu Viagem", "Vou viajar pra Dublin! Abraços...", new AuthorDTO(diego));
        Post post2 = new Post(null, sdf.parse("06/03/2018"), "Viagem Foi Otíma!", "Muito legal, obrigado pelo apoio!", new AuthorDTO(diego));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(cris));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(jp));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(jp));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));
        postRepo.saveAll(Arrays.asList(post1, post2));

        diego.getPosts().addAll(Arrays.asList(post1, post2));
        userRepo.save(diego);

    }

}
