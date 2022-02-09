package com.example.javaspringassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StreetDto {
    private Integer id;
    private String name;
    private String description;
    private String status;
    private Integer districtId;
}
