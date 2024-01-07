package com.bms.BookMyShow.repo;

import com.bms.BookMyShow.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {


    @Query(nativeQuery = true,
            value = "select * " + "from Movies " + "where release_date >= ?1")
    public List<Movies> findAllLatestMovies(Date date);
}
