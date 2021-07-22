package com.bnamericas.holidays.repository;

import com.bnamericas.holidays.model.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidaysRepository extends JpaRepository<Holidays, Long> {

}
