package com.ss.lms.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.ss.lms.dao.BookCopiesDao;
import com.ss.lms.dao.BookDao;
import com.ss.lms.dao.LibraryBranchDao;
import com.ss.lms.entity.Book;
import com.ss.lms.entity.BookCopies;
import com.ss.lms.entity.BookCopiesComposite;
import com.ss.lms.entity.LibraryBranch;

@Component
public class BookCopiesService {
    
	@Autowired
	BookCopiesDao bookCopiesDao;
	@Autowired 
	LibraryBranchDao libraryBranchDao;
	@Autowired
	BookDao bookDao;
	
	public ResponseEntity<?> getBookListByBranchId(int libraryBranchId){
		
		Optional<LibraryBranch> libraryBranch = libraryBranchDao.findById(libraryBranchId);
		if(!libraryBranch.isPresent()){
			return new ResponseEntity<String>("Branch doesn't exist.",HttpStatus.NOT_FOUND);
		}else {
		List<BookCopies> bookCopyList= bookCopiesDao.findAll().stream()
		.filter(x -> x.getBookCopiesComposite().getBranch().getBranchId()==libraryBranchId )
		.collect(Collectors.toList());
			return new ResponseEntity<List<BookCopies>>(bookCopyList,HttpStatus.FOUND);
		
		}
		
	}
    
	
	public ResponseEntity<BookCopies> getBookCopies(int branchId, int bookId){
		
		BookCopiesComposite bookCopiesComposite = new BookCopiesComposite(bookDao.findById(bookId).get(),
				                                                          libraryBranchDao.findById(branchId).get());
		List<BookCopies> bookList = bookCopiesDao.findAll();
		
		bookList = bookList.stream()
				.filter(x -> x.getBookCopiesComposite().equals(bookCopiesComposite))
				.collect(Collectors.toList());
		
		BookCopies bookCopies = bookList.get(0);
		if(bookCopies.getNoOfCopies()==0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<>(bookCopies,HttpStatus.FOUND);
		}
	}
	
	
	public ResponseEntity<String> updateNoOfCopies(int branchId, int bookId, int noOfCopies){
		LibraryBranch libraryBranch = libraryBranchDao.findById(branchId).get();
		Book book = bookDao.findById(bookId).get();
		BookCopiesComposite bookCopiesComposite = new BookCopiesComposite(book,libraryBranch);
		if(libraryBranch.getBranchId()==0) {
			return new ResponseEntity<>("Library Branch doesn't exist.",HttpStatus.NOT_FOUND);
		}
		else {
			if(book.getBookId()==0) {
				return new ResponseEntity<>("Book doesn't exist.",HttpStatus.NOT_FOUND);
			}
			else {
				BookCopies bookCopies = new BookCopies(bookCopiesComposite,noOfCopies);
				  bookCopiesDao.save(bookCopies);
					return new ResponseEntity<>("update successfull.",HttpStatus.NO_CONTENT);
			}
		}
	}

	
}
