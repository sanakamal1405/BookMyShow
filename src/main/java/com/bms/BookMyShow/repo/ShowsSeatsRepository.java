package com.bms.BookMyShow.repo;

import com.bms.BookMyShow.entities.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsSeatsRepository extends JpaRepository<ShowSeats, Long> {
}
