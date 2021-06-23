package com.rup.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rup.mongodb.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
