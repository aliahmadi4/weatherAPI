package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> getAllByDateOrderById(Date date);

    List<Weather> getAllByLocation_LatAndLocation_Lon(Float lat, Float lon);

    @Transactional
    void deleteAllByDateBetweenAndLocation_LatAndLocation_Lon(Date start, Date end, Float lat, Float lon);

}
