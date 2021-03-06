package com.daniel.service;

import java.util.List;
import java.util.Optional;

import com.daniel.entity.Location;

public interface LocationService {
	
	void saveLocation(Location location);
	
	void deleteLocationById(Long idLocation);
	
	void updateLocation(Location location);
	
	List<Location> findAllLLocations();
	
	Location findById(Long idLocation);
	
	
}
