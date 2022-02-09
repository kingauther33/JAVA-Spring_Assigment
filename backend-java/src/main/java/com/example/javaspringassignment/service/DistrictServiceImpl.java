package com.example.javaspringassignment.service;

import com.example.javaspringassignment.entity.District;
import com.example.javaspringassignment.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public District save(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District update(District district) {
        return districtRepository.save(district);
    }

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public Optional<District> findById(int id) {
        return districtRepository.findById(id);
    }

    @Override
    public boolean delete(District district) {
        districtRepository.delete(district);
        return true;
    }
}
