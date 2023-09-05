package com.bookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.Entity.MyBooks;
import com.bookStore.Repository.MyBooksRepository;

@Service
public class MyBooksService {

	@Autowired
	private MyBooksRepository mbRepo;
	
	
	public void saveMyBooks(MyBooks mBook) {
		mbRepo.save(mBook);
	}
    
	public List<MyBooks> getAllMyBooks() {
		
		return mbRepo.findAll();
	}
	
	public void deleteById(int id) {
		 mbRepo.deleteById(id);
	}
}
