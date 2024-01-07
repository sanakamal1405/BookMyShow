package com.bms.BookMyShow.dtos;

import com.bms.BookMyShow.enums.Format;
import com.bms.BookMyShow.enums.Genre;
import com.bms.BookMyShow.enums.Languages;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Builder
@Getter
@Setter
@Data
public class MovieDTO {
    private List<Languages> lang;

    private Format format;

    Genre genre;


    private  Double pricePerPerson;
    private String title;
    private String description;
    private int rating;

    private String releaseDate;
}
