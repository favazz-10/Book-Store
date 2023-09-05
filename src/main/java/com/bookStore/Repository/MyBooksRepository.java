package com.bookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.Entity.MyBooks;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBooks, Integer>{

	
}
