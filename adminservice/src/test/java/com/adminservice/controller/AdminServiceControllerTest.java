package com.adminservice.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.adminservice.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AdminController.class)
public class AdminServiceControllerTest {
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void getAllEmployeesAPI() throws Exception 
	{
	  mvc.perform(MockMvcRequestBuilders
	  			.get("/viewcustomers")
	  			.accept(MediaType.APPLICATION_JSON))
	      .andDo(MockMvcResultHandlers.print())
	      .andExpect( MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.customers").exists())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.customers[*].id").isNotEmpty());
	}
	 
	@Test
	public void getEmployeeByIdAPI() throws Exception 
	{
	  mvc.perform( MockMvcRequestBuilders
		      .get("/customerbyid/{id}", 1)
		      .accept(MediaType.APPLICATION_JSON))
	      .andDo(MockMvcResultHandlers.print())
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
	}
	
	@Test
	public void createEmployeeAPI() throws Exception 
	{
		Customer cc=new Customer();
		cc.setName("Sohan");
		cc.setAddress("Bangalore");
		cc.setEmail("abc@gmail.com");
		cc.setGender("Male");
		cc.setMobile("9886345721");
		cc.setPassword("abcd");
		cc.setPincode("567665");
	  mvc.perform( MockMvcRequestBuilders
		      .post("/AddCustomer")
		      .content(asJsonString(cc))
		      .contentType(MediaType.APPLICATION_JSON)
		      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isCreated())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
	}
	 
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}