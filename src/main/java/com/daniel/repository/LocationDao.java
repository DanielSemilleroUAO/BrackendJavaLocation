package com.daniel.repository;

import java.util.List;

import com.daniel.entity.Location;


public interface LocationDao {
	
	void saveLocation(Location location);
	
	void deleteLocationById(Long idLocation);
	
	void updateLocation(Location location);
	
	List<Location> findAllLocations();
	
	Location findById(Long idLocation);	
	
}
