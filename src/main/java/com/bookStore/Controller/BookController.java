package com.bookStore.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.MyBooks;
import com.bookStore.Service.BookService;
import com.bookStore.Service.MyBooksService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;

	@Autowired
	private MyBooksService mbService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	
	@GetMapping("/available_books")
	public String getAllBooks(Model m){
		List<Book> bList=service.getAllBooks();
		m.addAttribute("bList",bList);
		return "bookList";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		
		return "redirect:/available_books";
	}
	
    @GetMapping("/my_books")
    public String getMyBooks(Model m) {
    	List<MyBooks> mbList=mbService.getAllMyBooks();
    	m.addAttribute("mbList",mbList);
    	return "myBooks";
    }
	
    @RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
    	Book b=service.getBookById(id);
    	MyBooks mb=new MyBooks(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
    	mbService.saveMyBooks(mb);
    	return "redirect:/my_books";
    }
    
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model m) {
    	Book b=service.getBookById(id);
    	m.addAttribute("b",b);
    	return "editBook";
    }
    
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
    	service.deleteBook(id);
    	return "redirect:/available_books";
    }
	
}
