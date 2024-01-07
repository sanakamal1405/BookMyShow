package com.bms.BookMyShow.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Data
public abstract class BmsFunFacility extends BaseModel {

    protected   Double pricePerPerson;
    protected String title;
    protected String description;
    protected int rating;


}
