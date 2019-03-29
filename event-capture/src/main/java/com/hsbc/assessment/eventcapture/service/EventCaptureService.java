package com.hsbc.assessment.eventcapture.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventCaptureService {

	public List<String> getLondonEventCategories(String uri) throws IOException {

		Elements links = Jsoup.connect(uri).get().select("li")
				.select("a[href]");
		List<String> eventCategories = new ArrayList<String>();
		for (Element link : links) {
			if (Objects.nonNull(link.attr("href"))
					&& link.attr("href").contains("events/categories")) {
				eventCategories.add(link.text());
			}
		}
		return eventCategories;
	}

	public List<String> getLondonMusicEvent(String uri) throws IOException {
		Elements links = Jsoup.connect(uri).get().select("script");
		List<String> events = new ArrayList<String>();

		for (Element link : links) {
			if (Objects.nonNull(link.attr("type"))
					&& link.attr("type").equals("application/ld+json")) {
				events.add(link.data());
			}
		}
		return events;
	}

	public List<String> getLondonCategoryEvent(String category, String uri)
			throws IOException {
		Elements links = Jsoup.connect(uri).get().select("script");
		List<String> events = new ArrayList<String>();

		for (Element link : links) {
			if (Objects.nonNull(link.attr("type"))
					&& link.attr("type").equals("application/ld+json")) {
				events.add(link.childNodes().get(0).attributes().asList()
						.get(0).getValue());
			}
		}
		return events;
	}
}
