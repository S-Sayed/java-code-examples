package com.hyke.mobilesearch.service;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyke.mobilesearch.dao.MobileDAO;
import com.hyke.mobilesearch.model.Handset;
import com.hyke.mobilesearch.predicate.HandsetPredicateGenerator;

@Service
public class MobileService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MobileService.class);

	@Autowired
	private MobileDAO mobileDAO;

	public List<Handset> search(Map<String, String> criteria) {
		LOGGER.info("search - criteria {}", criteria);

		List<Handset> mobileDevices = mobileDAO.getAllDevices();

		if (mobileDevices != null && !(mobileDevices.isEmpty())) {
			List<Predicate<Handset>> predicates = HandsetPredicateGenerator.generate(criteria);
			
			if (predicates != null && !(predicates.isEmpty())) {
				mobileDevices = mobileDevices.stream().filter(predicates.stream().reduce(p -> true, Predicate::and))
						.collect(Collectors.<Handset>toList());
			}
		}

		return mobileDevices;
	}
}