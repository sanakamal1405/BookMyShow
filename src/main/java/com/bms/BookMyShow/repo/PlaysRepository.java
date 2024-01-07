package com.bms.BookMyShow.repo;

import com.bms.BookMyShow.entities.Plays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaysRepository extends JpaRepository<Plays, Long> {
}
