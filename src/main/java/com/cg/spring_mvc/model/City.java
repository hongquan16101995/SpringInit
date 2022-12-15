package com.cg.spring_mvc.model;

public class City {
    private Long id_city;
    private String name;

    public City(Long id, String name) {
        this.id_city = id;
        this.name = name;
    }

    public Long getId() {
        return id_city;
    }

    public void setId(Long id) {
        this.id_city = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
