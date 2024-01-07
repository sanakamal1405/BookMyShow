package com.bms.BookMyShow.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Data
public class Theatres extends BaseModel{
    private String address;

    @OneToMany(mappedBy = "theatres", cascade= CascadeType.ALL)
    @JsonBackReference
    private List<Shows> shows;

    @ManyToOne
    @JoinColumn(name="city_id")
    private Cities city;
}
