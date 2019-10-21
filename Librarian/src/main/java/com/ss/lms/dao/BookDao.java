package com.ss.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.entity.Book;


@Repository
public interface BookDao extends JpaRepository<Book, Integer>{

}
