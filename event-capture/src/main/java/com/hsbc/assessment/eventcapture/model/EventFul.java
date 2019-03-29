package com.hsbc.assessment.eventcapture.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@AllArgsConstructor
@Getter
@Setter
public class EventFul {

	public String categories;
	public String eventName;
	public String dateTime;
	public String venue;

}
