package com.daniel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.daniel.entity.Location;
import com.daniel.service.LocationService;
import com.daniel.util.CustomErrorType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
@Tag(name = "Service Location Controller")
public class LocationController {

	@Autowired
	private LocationService locationService;

	// Get
	@Operation(summary = "Get all locations", description = "retrieve all locations")
	@GetMapping("/locations")
	public ResponseEntity<List<Location>> getLocations() {
		List<Location> locations = new ArrayList<>();
		locations = locationService.findAllLLocations();
		if (locations.isEmpty()) {
			return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
	}

	// Get
	@Operation(summary = "Get location by id")
	@GetMapping(value = "/locations/{id}")
	public ResponseEntity<Location> getLocationById(@PathVariable("id") Long idLocation) {
		if (idLocation == null || idLocation < 0) {
			return new ResponseEntity(new CustomErrorType("idSocialMedia is required"), HttpStatus.CONFLICT);
		}

		Location location = locationService.findById(idLocation);
		if (location == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}

	// Post
	@Operation(summary = "Create Location")
	@PostMapping("/locations")
	public ResponseEntity<?> createLocation(@RequestBody Location location,
			UriComponentsBuilder uriComponentsBuilder) {
		if (location.getName().equals(null) || location.getName().isEmpty()) {
			return new ResponseEntity(new CustomErrorType("name is required"), HttpStatus.CONFLICT);
		}

		locationService.saveLocation(location);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/socialMedias/{id}").buildAndExpand(location).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// UPDATE
	@Operation(summary = "Update Location by Id")
	@PatchMapping("/locations/{id}")
	public ResponseEntity<?> updateLocation(@PathVariable("id") Long idLocation, @RequestBody Location location) {

		if (idLocation == null || idLocation <= 0) {
			return new ResponseEntity(new CustomErrorType("idLocation is required"), HttpStatus.CONFLICT);
		}

		Location currentLocation = locationService.findById(idLocation);
		if (currentLocation == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		currentLocation.setName(location.getName());
		currentLocation.setArea(location.getArea());

		locationService.updateLocation(currentLocation);

		return new ResponseEntity<Location>(currentLocation, HttpStatus.OK);

	}

	// Delete
	@Operation(summary = "Delete location by id")
	@DeleteMapping("/locations/{id}")
	public ResponseEntity<?> deleteLocation(@PathVariable("id") Long idLocation) {

		if (idLocation == null || idLocation <= 0) {
			return new ResponseEntity(new CustomErrorType("idSocialMedia is required"), HttpStatus.CONFLICT);
		}

		Location currentLocation = locationService.findById(idLocation);
		if (currentLocation == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		locationService.deleteLocationById(idLocation);

		return new ResponseEntity<Location>(HttpStatus.OK);

	}

}
