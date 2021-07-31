package com.daniel;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.daniel.entity.Location;
import com.daniel.repository.LocationDao;
import com.daniel.service.LocationServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class LocationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	LocationServiceImpl locationService;
	@Mock
	LocationDao dataServiceMock;
	
	@Test
	public void getDataLocationService_basic() {
		when(dataServiceMock.findById((long) 1)).thenReturn(new Location("Cali",50));
		assertEquals("Cali", locationService.findById((long) 1).getName());
	}
	
	@Test
	public void getListLocationService_basic() {
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("", 0));
		when(dataServiceMock.findAllLocations()).thenReturn(locations);
		assertEquals(1, locationService.findAllLLocations().size());
	}
	
	/*
	@Test
	public void locationControllerTest_getAllLocations() throws Exception {
		this.mockMvc.perform(get("/api/v1/locations/8")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"idLocation\":8,\"name\":\"Cali\",\"area\":0.0}")));
	}
	
	@Test
	public void locationControllerTest_getAllLocationById() throws Exception {
		this.mockMvc.perform(get("/api/v1/locations/2")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"idLocation\":2,\"name\":\"Bogota\",\"area\":70.0}")));
	}
	
	@Test
	public void locationControllerTest_postCreateLocation() throws Exception {
		this.mockMvc.perform(post("/api/v1/locations").content("{\"name\":\"Cali\",\"area\": 70}")).andDo(print()).andExpect(status().isCreated());
	}
	
	@Test
	public void locationControllerTest_updateLocation() throws Exception {
		this.mockMvc.perform(patch("/api/v1/locations").content("{\"name\":\"Cali\",\"area\": 90}")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"name\":\"Cali\",\"area\": 90}")));
	}
	
	@Test
	public void locationControllerTest_deleteLocation() throws Exception {
		this.mockMvc.perform(delete("/api/v1/locations/3")).andDo(print()).andExpect(status().isOk());
	}
	*/
}
