package com.ss.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.entity.BookCopies;
import com.ss.lms.entity.BookCopiesComposite;

@Repository
public interface BookCopiesDao extends JpaRepository<BookCopies, BookCopiesComposite>{

	
}
