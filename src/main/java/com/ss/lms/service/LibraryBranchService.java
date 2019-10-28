package com.ss.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ss.lms.dao.LibraryBranchDao;
import com.ss.lms.entity.LibraryBranch;

@Component
public class LibraryBranchService {
	
	private static LibraryBranchService instance = null;

	private LibraryBranchService() {
		// Exists only to defeat instantiation.
	}

	public static LibraryBranchService getInstance() {
		if (instance == null) {
			instance = new LibraryBranchService();
		}
		return instance;
	}

	@Autowired
	LibraryBranchDao libraryBranchDao;
	
	
	public List<LibraryBranch> getAllLibraryBranch() {
		return libraryBranchDao.findAll();
	}
	
	public ResponseEntity<?> getLibraryBranchById(Integer libraryBranchId) {
		Optional<LibraryBranch> libraryBranch = libraryBranchDao.findById(libraryBranchId);
		
		if(!libraryBranch.isPresent() ){
			return new ResponseEntity<String>("Branch doesn't exist.",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<LibraryBranch>(libraryBranch.get(),HttpStatus.FOUND);
		}
		
	}
	
	public boolean doesLibraryBranchExist(LibraryBranch libraryBranch) {
		return libraryBranchDao.existsById(libraryBranch.getBranchId());
	}
	
	public ResponseEntity<LibraryBranch> updateLibraryBranch(LibraryBranch libraryBranch) {
		if(doesLibraryBranchExist(libraryBranch)==true) {
			libraryBranchDao.save(libraryBranch);
			return new ResponseEntity<>(libraryBranch,HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(libraryBranch,HttpStatus.NOT_FOUND);
		}
		
	}
}
