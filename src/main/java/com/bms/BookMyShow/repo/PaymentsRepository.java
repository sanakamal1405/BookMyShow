package com.bms.BookMyShow.repo;

import com.bms.BookMyShow.entities.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
}
