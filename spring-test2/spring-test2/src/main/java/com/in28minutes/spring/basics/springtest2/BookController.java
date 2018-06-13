package com.in28minutes.spring.basics.springtest2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@GetMapping("/books")
	public List<Book> getAllBook(){
		return Arrays.asList(new Book(11, "Mastering Spring 5.0", "Sean"));
	}
}
