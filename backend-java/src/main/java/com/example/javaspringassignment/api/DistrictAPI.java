package com.example.javaspringassignment.api;

import com.example.javaspringassignment.entity.District;
import com.example.javaspringassignment.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/districts")
public class DistrictAPI {

    @Autowired
    private DistrictService districtService;

    // Create new street
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody District district) {
        district.setStreetSet(new HashSet<>());
        districtService.save(district);

        return new ResponseEntity<>(district, HttpStatus.CREATED);
    }

    // Get all streets
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList() {
        return new ResponseEntity<>(districtService.findAll(), HttpStatus.OK);
    }

    // Get street detail
    @RequestMapping(method = RequestMethod.GET, path="{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id) {
        Optional<District> optionalDistrict = districtService.findById(id);

        if (optionalDistrict.isPresent()) {
            return new ResponseEntity<>(optionalDistrict.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Update street
    @RequestMapping(method = RequestMethod.PUT, path="{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody District updatedDistrict) {
        Optional<District> optionalDistrict = districtService.findById(id);

        // Trường hợp == null thì trả về 404
        if (optionalDistrict.isPresent()) {
            District district = optionalDistrict.get();
            district.setName(updatedDistrict.getName());
            districtService.save(district);

            return new ResponseEntity<>(district, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
