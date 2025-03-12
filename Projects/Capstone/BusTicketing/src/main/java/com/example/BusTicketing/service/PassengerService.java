package com.example.BusTicketing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BusTicketing.domain.Passenger;
import com.example.BusTicketing.repository.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository repo;

    public List<Passenger> listAll() {
        return repo.findAll();
    }

    public void save(Passenger std) {
        repo.save(std);
    }

    public Passenger get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

}