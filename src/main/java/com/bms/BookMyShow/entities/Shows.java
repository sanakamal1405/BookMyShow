package com.bms.BookMyShow.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity

@SuperBuilder(toBuilder = true)
@Getter
@Data
@NoArgsConstructor

public class Shows extends BaseModel{

    private Date startDate;
    private Timestamp startTime;

    @OneToMany(mappedBy = "show", cascade=CascadeType.ALL)
    @JsonManagedReference
    List<ShowSeats> seats;

    @ManyToOne
    @JoinColumn(name="theatre_id")
    @JsonManagedReference//doesnt exists in JSON
    private Theatres theatres;


    @Override
    public String toString() {
        return "Shows{" +
                "startDate=" + startDate +
                ", startTime=" + startTime +
                ", seats=" + seats +
                ", theatres=" + theatres +
                ", bmsFunFacility_id=" + bmsFunFacility_id +
                '}';
    }

    private Long bmsFunFacility_id;

    // private BookMyShowFunFacilityType type ; based on  type movie/activity injection in showsRepo


}
