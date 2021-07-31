package com.daniel.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.daniel.entity.Location;

@Repository
@Transactional
public class LocationDaoImpl extends AbsctractSession implements LocationDao{

	@Override
	public List<Location> findAllLocations() {
		// TODO Auto-generated method stub
		return getSessionFactory().createQuery("from Location").list();
	}


	@Override
	public void saveLocation(Location location) {
		// TODO Auto-generated method stub
		location.setIdLocation((long) 0);
		getSessionFactory().persist(location);
	}

	@Override
	public void deleteLocationById(Long idLocation) {
		// TODO Auto-generated method stub
		Location location = findById(idLocation);
		if(location != null) {
			getSessionFactory().delete(location);
		}
	}

	@Override
	public void updateLocation(Location location) {
		// TODO Auto-generated method stub
		getSessionFactory().update(location);
	}

	@Override
	public Location findById(Long idLocation) {
		// TODO Auto-generated method stub
		return (Location) getSessionFactory().get(Location.class, idLocation);
	}

}
