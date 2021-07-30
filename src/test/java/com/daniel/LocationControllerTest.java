package com.daniel;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.daniel.entity.Location;

@SpringBootTest
@AutoConfigureMockMvc
class LocationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void locationControllerTest_getAllLocations() throws Exception {
		this.mockMvc.perform(get("/api/v1/locations")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("[{\"idLocation\":2,\"name\":\"Bogota\",\"area\":70.0}]")));
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
	
}
