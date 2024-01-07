package com.bms.BookMyShow.repo;

import com.bms.BookMyShow.entities.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<Cities, Long> {
}
