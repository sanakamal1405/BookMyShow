package com.bms.BookMyShow.dtos;

import com.bms.BookMyShow.entities.Theatres;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Data
@Setter
public class CitiesDTO {
    private String location;
    private List<Theatres> theatres;
}
