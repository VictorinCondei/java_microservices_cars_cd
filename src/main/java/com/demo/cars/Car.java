package com.demo.cars;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = -3240337073623122124L;

    private Integer carId;
    private String name;
    private String genre;

    public Car(Integer carId, String name, String genre) {
        this.carId = carId;
        this.name = name;
        this.genre = genre;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}