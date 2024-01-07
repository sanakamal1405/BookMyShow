package com.bms.BookMyShow.entities;

import com.bms.BookMyShow.enums.Format;
import com.bms.BookMyShow.enums.Genre;
import com.bms.BookMyShow.enums.Languages;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@Getter
public class Movies extends BmsFunFacility{

    @ElementCollection
    @Enumerated
    private List<Languages> lang;

    @Enumerated
    private Format format;

    @Enumerated
    private Genre genre;

    private Date releaseDate;



}
