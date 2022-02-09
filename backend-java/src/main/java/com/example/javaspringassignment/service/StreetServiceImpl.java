package com.example.javaspringassignment.service;

import com.example.javaspringassignment.entity.Street;
import com.example.javaspringassignment.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetRepository streetRepository;

    @Override
    public Street save(Street street) {
        return streetRepository.save(street);
    }

    @Override
    public Street update(Street street) {
        return streetRepository.save(street);
    }

    @Override
    public List<Street> findAll() {
        return streetRepository.findAll();
    }

    @Override
    public List<Street> findByKeywordAndPage(String searchName, String district_id, int offset, int limit) {
        return streetRepository.findByPageAndLimit(searchName, district_id, offset, limit);
    }


    public Optional<Street> findById(int id) {
        return streetRepository.findById(id);
    }

    @Override
    public boolean delete(Street street) {
        streetRepository.delete(street);
        return true;
    }

    @Override
    public Long countAll() {
        return streetRepository.count();
    }

    @Override
    public List<Street> findAllByNameAndDistrictId(String name, String district_id) {
        return streetRepository.findAllByNameAndDistrict_id(name, district_id);
    }
}
