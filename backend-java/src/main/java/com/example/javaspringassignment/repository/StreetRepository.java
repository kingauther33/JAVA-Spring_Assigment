package com.example.javaspringassignment.repository;

import com.example.javaspringassignment.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Integer> {
    @Query(value = "SELECT * FROM streets s " +
            "where s.name LIKE %?1% and  s.district_id LIKE %?2% " +
            "ORDER BY s.id LIMIT ?3, ?4 ", nativeQuery = true)
    List<Street> findByPageAndLimit(String searchName, String district_id, int offset, int limit);

    @Query(value = "SELECT * FROM streets s " +
            "where s.name LIKE %?1% and  s.district_id LIKE %?2% "
            , nativeQuery = true)
    List<Street> findAllByNameAndDistrict_id(String searchName, String district_id);


//    @Query(value = "SELECT * FROM streets s " +
//            "where ( ?1 = \"\" or s.name LIKE %?1% ) and  ( ?2 = \"\" or s.district_id LIKE %?2%  ) ", nativeQuery = true)
//    List<Street> countAllByNameAndDistrict_id(String name, String district_id);

//    Long countAllByNameAndDistrict_id(String name, int districtId);
//    List<Street> findAllByNameAndDistrict_id(String name, Integer districtId);
}
