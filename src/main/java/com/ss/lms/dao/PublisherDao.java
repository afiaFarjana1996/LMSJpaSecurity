package com.ss.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.entity.Publisher;


@Repository
public interface PublisherDao extends JpaRepository<Publisher, Integer>{

}
