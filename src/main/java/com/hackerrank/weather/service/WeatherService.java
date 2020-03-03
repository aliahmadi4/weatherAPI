package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface WeatherService {

    ResponseEntity save(Weather weather);
    List<Weather> getAllWeathers();
    void deleteAll();
    List<Weather> getAllByDate(Date date);
    List<Weather> getAllByLocation(Float lat, Float lon);
    void deleteByDateAndLocation(Date start, Date end, Float lat, Float lon);

}
