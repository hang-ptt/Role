package com.hybrid.usermanagement.service;

import com.hybrid.usermanagement.entity.Location;
import com.hybrid.usermanagement.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> getAll(){
        return locationRepository.findByStatus(true);
    }
}
