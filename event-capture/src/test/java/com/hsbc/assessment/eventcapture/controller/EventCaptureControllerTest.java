package com.hsbc.assessment.eventcapture.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import com.hsbc.assessment.eventcapture.service.EventCaptureService;

@RunWith(SpringRunner.class)
@WebMvcTest(EventCaptureController.class)
public class EventCaptureControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
    private EventCaptureService service;
	
	@InjectMocks
	private EventCaptureController testObj;
	
	@Test
	public void testAllLonDonEvents() throws Exception {
		when(service.getLondonEventCategories(Mockito.anyString())).thenReturn(anyList());
		mockMvc.perform(MockMvcRequestBuilders.get(EventCaptureController.LONDON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testInvalidEventCategory() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(EventCaptureController.MUSIC))
			.andExpect(status().isNotFound())
			.andExpect(jsonPath("$.message").value("Something went wrong."));
			}

}
