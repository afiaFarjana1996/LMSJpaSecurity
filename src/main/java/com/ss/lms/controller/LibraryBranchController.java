package com.ss.lms.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ss.lms.entity.LibraryBranch;
import com.ss.lms.service.LibraryBranchService;

@RestController
@RequestMapping("lms/librarian/")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class LibraryBranchController {
    
	@Autowired
	LibraryBranchService libraryBranchService;
	
	@GetMapping(path="list")
	public List<LibraryBranch> getAllLibraryBranch() {
		return libraryBranchService.getAllLibraryBranch();
	}
	
	@GetMapping(path="id/{libraryBranchId}")
	public ResponseEntity<?> getLibraryBranchById(@PathVariable int libraryBranchId){
		return libraryBranchService.getLibraryBranchById(libraryBranchId);
		
		
	}
	
	@PutMapping(path="branchChange")
	public ResponseEntity<LibraryBranch> updateLibraryBranch(@RequestBody LibraryBranch libraryBranch) {
		
		return libraryBranchService.updateLibraryBranch(libraryBranch);
		
	}
	
	@GetMapping(path="health")
	public HttpStatus isHealthy() {
		return HttpStatus.OK;
	}
	
	
}
