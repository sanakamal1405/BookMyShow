package com.bms.BookMyShow.repo;

import com.bms.BookMyShow.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Activity, Long> {
}
