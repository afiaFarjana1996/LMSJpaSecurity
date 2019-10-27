package com.ss.lms.controller;



import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.entity.ReadBookCopies;
import com.ss.lms.service.BookCopiesService;



@RestController
@RequestMapping("lms/librarian/")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class BookCopiesController {

	@Autowired
	BookCopiesService bookCopiesService;
	
	@GetMapping(path="library-branch/id/{libraryBranchId}/book-list")
	public ResponseEntity<?> getBookListByBranchId(@PathVariable int libraryBranchId){
		
		return bookCopiesService.getBookListByBranchId(libraryBranchId);
		
	}
	
	
	@PutMapping(path="copyAddition")
	public ResponseEntity<String> updateNoOfCopies(@RequestBody ReadBookCopies readBookCopies) {
		
		return bookCopiesService.updateNoOfCopies(readBookCopies.getBranchId(), readBookCopies.getBookId(), readBookCopies.getNoOfCopies());
	}
}
