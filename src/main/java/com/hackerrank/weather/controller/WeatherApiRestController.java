package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import com.hackerrank.weather.service.WeatherService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class WeatherApiRestController {
    @Autowired
    WeatherService weatherService;

    @RequestMapping(value = "/weather", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addNewWeather(@RequestBody @Valid Weather weather){
        return weatherService.save(weather);
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Weather> getAllWeathers(){
        return weatherService.getAllWeathers();
    }

    @RequestMapping(value = "/erase", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll(){
        weatherService.deleteAll();
    }

    @RequestMapping(value = "/weather", params = {"date"} ,method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllWeathersByDate(@Param("date") String date) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sd.parse(date);
        List<Weather> weathers = weatherService.getAllByDate(date1);
        if(weathers.size()==0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(weathers);
    }

    @RequestMapping(value = "/weather", params = {"lat", "lon"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllWeathersByLocation(@Param("lat") Float lat, @Param("lon") Float lon){
        List<Weather> weathers = weatherService.getAllByLocation(lat,lon);
        if(weathers.size()==0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(weathers);
    }

    @RequestMapping(value = "/erase", params = {"start", "end", "lat", "lon"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllWeathersByDateAndLocation(@Param("start") String start,
                                                   @Param("end") String end,
                                                   @Param("lat") Float lat,
                                                   @Param("lon") Float lon) throws ParseException {

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date start1 = sd.parse(start);
        Date end1 = sd.parse(end);
        weatherService.deleteByDateAndLocation(start1, end1, lat, lon);
    }



}
