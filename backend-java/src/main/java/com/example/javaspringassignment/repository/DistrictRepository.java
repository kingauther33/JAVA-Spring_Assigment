package com.example.javaspringassignment.repository;

import com.example.javaspringassignment.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Integer> {
}
