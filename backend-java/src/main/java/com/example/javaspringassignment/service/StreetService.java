package com.example.javaspringassignment.service;


import com.example.javaspringassignment.entity.Street;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StreetService {

    Street save(Street street);

    Street update (Street street);

    List<Street> findAll();

    List<Street> findByKeywordAndPage(String searchName, String district_id, int offset, int limit);

    Optional<Street> findById(int id);

    boolean delete(Street street);

    Long countAll();

    List<Street> findAllByNameAndDistrictId(String name, String district_id);
}
