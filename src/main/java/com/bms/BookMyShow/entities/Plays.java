package com.bms.BookMyShow.entities;

import com.bms.BookMyShow.enums.Concept;
import com.bms.BookMyShow.enums.Languages;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.util.List;

@Entity

@SuperBuilder

@NoArgsConstructor
public class Plays extends BmsFunFacility{

    @Enumerated
    private Concept concept;


    @Enumerated
    @ElementCollection
    List<Languages> lang;

    private Date showDate;
}
