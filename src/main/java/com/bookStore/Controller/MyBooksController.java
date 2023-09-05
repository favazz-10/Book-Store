package com.bookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.Service.MyBooksService;

@Controller
public class MyBooksController {

	@Autowired
	private MyBooksService mbService;
	
	@RequestMapping("/deleteMyBooks/{id}")
	public String deleteMyBooks(@PathVariable("id") int id) {
		mbService.deleteById(id);
		return "redirect:/my_books";
	}
}
