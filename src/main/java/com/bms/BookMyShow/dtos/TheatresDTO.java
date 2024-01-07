package com.bms.BookMyShow.dtos;

import com.bms.BookMyShow.entities.Shows;
import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Data
public class TheatresDTO {

    private List<Long> showsId;
    private String address;


    private String startDate;
    private Timestamp startTime;
    private Long bmsFunFacilityId;
}
