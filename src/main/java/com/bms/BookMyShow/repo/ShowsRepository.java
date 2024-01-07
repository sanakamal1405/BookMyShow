package com.bms.BookMyShow.repo;

import com.bms.BookMyShow.entities.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsRepository extends JpaRepository<Shows, Long> {
}
