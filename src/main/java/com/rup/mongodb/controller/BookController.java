package com.rup.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rup.mongodb.model.Book;
import com.rup.mongodb.repository.BookRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "Book is saved:" + book.getId();
	}

	@GetMapping("findAllBooks")
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@GetMapping("findBook/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Book deleted with id:" + id;
	}

}
