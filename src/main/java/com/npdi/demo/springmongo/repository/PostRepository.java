/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npdi.demo.springmongo.repository;

import com.npdi.demo.springmongo.domain.Post;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    public List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': { $regex : ?0, $options: 'i' } }")
    public List<Post> searchTitle(String text);

    @Query("{ $and: [ {date: {$gte: ?1}}, {date: {$lte: ?2}}, "
            + "{ $or: [ "
            + "{ 'title': { $regex : ?0, $options: 'i' } },"
            + "{ 'body': { $regex : ?0, $options: 'i' } }, "
            + "{ 'comments.text': { $regex : ?0, $options: 'i' } "
            + "} ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
