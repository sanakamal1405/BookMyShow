package com.bms.BookMyShow.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Data
public class Cities extends BaseModel{

    private String location;

    @OneToMany(mappedBy="city", cascade= CascadeType.ALL)
    private List<Theatres> theatres;
}
