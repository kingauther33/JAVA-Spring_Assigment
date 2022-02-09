package com.example.javaspringassignment.service;

import com.example.javaspringassignment.entity.District;

import java.util.List;
import java.util.Optional;

public interface DistrictService {
    District save(District street);

    District update (District street);

    List<District> findAll();

    Optional<District> findById(int id);

    boolean delete(District street);
}
