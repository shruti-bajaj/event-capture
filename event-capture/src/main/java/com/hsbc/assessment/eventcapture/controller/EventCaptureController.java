package com.hsbc.assessment.eventcapture.controller;

import io.swagger.annotations.ApiOperation;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hsbc.assessment.eventcapture.service.EventCaptureService;

@Slf4j
@RestController
@RequestMapping(value = "/events")
public class EventCaptureController {

	public static final String L = "l=";
	public static final String AND = "&";
	public static final String Q = "q=";
	public static final String SINGLES_SOCIAL = "/singles_social";
	public static final String SPORTS = "/sports";
	public static final String FAMILY_FUN_KIDS = "/family_fun_kids";
	public static final String COMEDY = "/comedy";
	public static final String MUSIC = "/music";
	public static final String APPLICATION_JSON = "application/json";
	public static final String LONDON_EVENTS_URL = "http://eventful.com/events/";
	public static final String LONDON = "/London";

	@Autowired
	EventCaptureService eventCaptureService;

	@ApiOperation(value = "Display all events in London")
	@GetMapping(value = LONDON, produces = APPLICATION_JSON)
	public ResponseEntity<String> getCategoriesOfLondonEvents()
			throws IOException {

		final String uri = LONDON_EVENTS_URL + L+"London";
		String result = new Gson().toJson(eventCaptureService
				.getLondonEventCategories(uri));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "Display Music events in London")
	@GetMapping(value = LONDON + MUSIC, produces = APPLICATION_JSON)
	public ResponseEntity<String> getLondonMusicEvents() throws IOException {

		final String uri = LONDON_EVENTS_URL + Q+"music" + AND+L+"London";
		String result = new Gson().toJson(eventCaptureService
				.getLondonCategoryEvent("Concerts", uri));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "Display Comedy events in London")
	@GetMapping(value = LONDON + COMEDY, produces = APPLICATION_JSON)
	public ResponseEntity<String> getLondonComedyEvents() throws IOException {

		final String uri = LONDON_EVENTS_URL + Q+"comedy" + AND+L+"London";
		String result = new Gson().toJson(eventCaptureService
				.getLondonCategoryEvent("Comedy", uri));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "Display Kids events in London")
	@GetMapping(value = LONDON + FAMILY_FUN_KIDS, produces = APPLICATION_JSON)
	public ResponseEntity<String> getLondonKidsEvents() throws IOException {

		String uri = LONDON_EVENTS_URL + Q+"family_fun_kids" + AND+L+"London";
		String result = new Gson().toJson(eventCaptureService
				.getLondonCategoryEvent("Kids", uri));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "Display Sports events in London")
	@GetMapping(value = LONDON + SPORTS, produces = APPLICATION_JSON)
	public ResponseEntity<String> getLondonSportsEvents() throws IOException {

		final String uri = LONDON_EVENTS_URL + Q+"sports" + AND+L+"London";
		String result = new Gson().toJson(eventCaptureService
				.getLondonCategoryEvent("Sports", uri));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ApiOperation(value = "Display Night Life events in London")
	@GetMapping(value = LONDON + SINGLES_SOCIAL, produces = APPLICATION_JSON)
	public ResponseEntity<String> getLondonNightLifeEvents() throws IOException {

		final String uri = LONDON_EVENTS_URL + Q+"singles_social" + AND+L+"London";
		String result = new Gson().toJson(eventCaptureService
				.getLondonCategoryEvent("NightLife", uri));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
