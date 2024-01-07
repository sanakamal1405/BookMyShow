package com.bms.BookMyShow.dtos;

import com.bms.BookMyShow.entities.Theatres;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Data
@Builder
public class ShowsDTO {


        private String startDate;
        private Timestamp startTime;
        private Long bmsFunFacilityId;


}
