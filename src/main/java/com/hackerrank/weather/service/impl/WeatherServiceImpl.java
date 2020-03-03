package com.hackerrank.weather.service.impl;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import com.hackerrank.weather.service.WeatherService;
import javassist.NotFoundException;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sun.security.provider.certpath.OCSPResponse;

import javax.management.BadAttributeValueExpException;
import java.util.Date;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    WeatherRepository weatherRepository;

    @Override
    public ResponseEntity save(Weather weather) {
        Weather weather1 = weatherRepository.findOne(weather.getId());

        if (weather1 != null) return ResponseEntity.status(400).build();
        weatherRepository.save(weather);
        return ResponseEntity.status(201).build();
    }

    @Override
    public List<Weather> getAllWeathers() {
        return weatherRepository.findAll();
    }

    @Override
    public void deleteAll() {
        weatherRepository.deleteAll();
    }

    @Override
    public List<Weather> getAllByDate(Date date) {
        List<Weather> weathers = weatherRepository.getAllByDateOrderById(date);
        return weathers;
    }

    @Override
    public List<Weather> getAllByLocation(Float lat, Float lon) {
        return weatherRepository.getAllByLocation_LatAndLocation_Lon(lat, lon);
    }

    @Override
    public void deleteByDateAndLocation(Date start, Date end, Float lat, Float lon) {
        weatherRepository.deleteAllByDateBetweenAndLocation_LatAndLocation_Lon(start,end,lat,lon);
    }
}
