package com.bms.BookMyShow.repo;

import com.bms.BookMyShow.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Tickets, Long> {
}
