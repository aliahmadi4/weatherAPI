package com.hackerrank.weather.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Entity
@Table(name = "weather")
public class Weather {
    @Id
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Location location;
    @Lob
    private Float[] temperature;

    public Weather() {
    }

    public Weather(Long id, Date date, Location location, Float[] temperature) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        dtf = dtf.withLocale(Locale.ENGLISH);
//        LocalDate ld = LocalDate.parse(date, dtf);
//        Date now = new Date();
//        System.out.println(date);
//        System.out.println(now);
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Float[] getTemperature() {
        return this.temperature;
    }

    public void setTemperature(Float[] temperature) {
        this.temperature = temperature;
    }

//    @Override
//    public String toString() {
//        return "Weather{" +
//                "id=" + id +
//                ", dateRecorded=" + date +
//                ", location=" + location +
//                ", temperature=" + temperature +
//                '}';
//    }
}
