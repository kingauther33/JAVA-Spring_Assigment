package com.example.javaspringassignment.api;

import com.example.javaspringassignment.dto.StreetDto;
import com.example.javaspringassignment.entity.District;
import com.example.javaspringassignment.entity.Street;
import com.example.javaspringassignment.service.DistrictService;
import com.example.javaspringassignment.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/streets")
public class StreetAPI {

    @Autowired
    private StreetService streetService;

    @Autowired
    private DistrictService districtService;

    static Logger LOGGER = Logger.getLogger(StreetAPI.class.getSimpleName());


    // Create new street
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody StreetDto streetDto) {
        District existedDistrict = districtService.findById(streetDto.getDistrictId()).orElse(null);
        if (existedDistrict == null) {
            return new ResponseEntity<>("Cannot find district", HttpStatus.NOT_FOUND);
        }

        Street street = Street.builder()
                .name(streetDto.getName())
                .description(streetDto.getDescription())
                .status(streetDto.getStatus())
                .district_id(existedDistrict.getId())
                .district(existedDistrict)
                .build();
        streetService.save(street);

        return new ResponseEntity<>(street, HttpStatus.CREATED);
    }

    // Get all streets
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int limit,
                                          @RequestParam(defaultValue = "") String name,
                                          @RequestParam(defaultValue = "") String districtId) {
        HashMap<String, Object> response = new HashMap<>();
        int offset = limit * page;
        if (districtId.equals("0")) districtId = "";

        List<Street> allStreetByNameAndDistrictId = streetService.findAllByNameAndDistrictId(name, districtId);
        response.put("page", page);
        response.put("limit", limit);
        response.put("count", allStreetByNameAndDistrictId.size());
        LOGGER.log(Level.INFO, String.valueOf(allStreetByNameAndDistrictId.size()));
        response.put("data", streetService.findByKeywordAndPage(name, districtId, offset, limit));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get street detail
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id) {
        Optional<Street> optionalStreet = streetService.findById(id);

        if (optionalStreet.isPresent()) {
            return new ResponseEntity<>(optionalStreet.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
