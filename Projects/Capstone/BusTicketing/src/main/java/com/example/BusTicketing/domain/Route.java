package com.example.BusTicketing.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "routes") // Map to the 'routes' table
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departure;
    private String destination;
    private String dep_time;
    private String ari_time;
    private Double pricing;

    public Route() {}

    public Route(String departure, String destination, String dep_time, String ari_time, Double pricing) {
        this.departure = departure;
        this.destination = destination;
        this.dep_time = dep_time;
        this.ari_time = ari_time;
        this.pricing = pricing;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDep_time() {
        return dep_time;
    }

    public void setDep_time(String dep_time) {
        this.dep_time = dep_time;
    }

    public String getAri_time() {
        return ari_time;
    }

    public void setAri_time(String ari_time) {
        this.ari_time = ari_time;
    }

    public Double getPricing() {
        return pricing;
    }

    public void setPricing(Double pricing) {
        this.pricing = pricing;
    }
}
