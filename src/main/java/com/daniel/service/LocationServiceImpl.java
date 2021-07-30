package com.daniel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.entity.Location;
import com.daniel.repository.LocationDao;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	private LocationDao locationDao;

	@Override
	public void saveLocation(Location location) {
		// TODO Auto-generated method stub
		locationDao.saveLocation(location);
	}

	@Override
	public void deleteLocationById(Long idLocation) {
		// TODO Auto-generated method stub
		locationDao.deleteLocationById(idLocation);
	}

	@Override
	public List<Location> findAllLLocations() {
		// TODO Auto-generated method stub
		return locationDao.findAllLocations();
	}

	@Override
	public Location findById(Long idLocation) {
		// TODO Auto-generated method stub
		return locationDao.findById(idLocation);
	}

	@Override
	public void updateLocation(Location location) {
		// TODO Auto-generated method stub
		locationDao.updateLocation(location);
	}

}
