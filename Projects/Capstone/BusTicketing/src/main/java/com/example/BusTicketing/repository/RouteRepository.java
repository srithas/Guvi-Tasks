package com.example.BusTicketing.repository;

import com.example.BusTicketing.domain.Route;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    // Custom query to find routes based on departure and destination
    List<Route> findByDepartureAndDestination(String departure, String destination);

    // Use EntityManager to insert booking into the correct table
    default void bookRoute(Long routeId, Long passengerId, EntityManager entityManager) {
        String query = "INSERT INTO route_bookings (route_id, passenger_id) VALUES (?, ?)";
        entityManager.createNativeQuery(query)
                .setParameter(1, routeId)
                .setParameter(2, passengerId)
                .executeUpdate();
    }
}
