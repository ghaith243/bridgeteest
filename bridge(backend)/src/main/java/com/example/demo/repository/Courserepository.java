package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.course;

public interface Courserepository extends JpaRepository<course,Long> {

}
