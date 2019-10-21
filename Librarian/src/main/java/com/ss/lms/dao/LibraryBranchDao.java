package com.ss.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.entity.LibraryBranch;

@Repository
public interface LibraryBranchDao extends JpaRepository<LibraryBranch, Integer>{


}
