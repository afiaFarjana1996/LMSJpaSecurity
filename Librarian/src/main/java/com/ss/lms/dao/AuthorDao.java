package com.ss.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.entity.Author;


@Repository
public interface AuthorDao extends JpaRepository<Author, Integer>{

}
