/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npdi.demo.springmongo.services;

import com.npdi.demo.springmongo.domain.Post;
import com.npdi.demo.springmongo.repository.PostRepository;
import com.npdi.demo.springmongo.services.exception.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        if (!post.isPresent()) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post.get();
    }
}
