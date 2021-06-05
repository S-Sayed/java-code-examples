package com.hyke.mobilesearch.predicate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hyke.mobilesearch.model.Handset;

public class HandsetPredicateGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(HandsetPredicateGenerator.class);

	public static List<Predicate<Handset>> generate(Map<String, String> criteria) {
		LOGGER.info("generate - criteria {}", criteria);

		List<Predicate<Handset>> predicates = new ArrayList<Predicate<Handset>>();

		criteria.entrySet().stream().filter(entry -> StringUtils.isNotBlank(entry.getValue())).forEach((entry) -> {

			switch (entry.getKey().toLowerCase()) {
			case "id":
				predicates.add(HandsetPredicateUtil.isIdEqual(Integer.parseInt(entry.getValue())));
				break;
			case "brand":
				predicates.add(HandsetPredicateUtil.isBrandEqual(entry.getValue()));
				break;
			case "phone":
				predicates.add(HandsetPredicateUtil.isPhoneEqual(entry.getValue()));
				break;
			case "picture":
				predicates.add(HandsetPredicateUtil.isPictureContain(entry.getValue()));
				break;
			case "announcedate":
				predicates.add(HandsetPredicateUtil.isAnnounceDateContain(entry.getValue()));
				break;
			case "priceeur":
				predicates.add(HandsetPredicateUtil.isPriceEurEqual(new BigDecimal(entry.getValue())));
				break;
			case "sim":
				predicates.add(HandsetPredicateUtil.isSimContain(entry.getValue()));
				break;
			case "resolution":
				predicates.add(HandsetPredicateUtil.isResolutionContain(entry.getValue()));
				break;
			case "audiojack":
				predicates.add(HandsetPredicateUtil.isAudioJackEqual(entry.getValue()));
				break;
			case "gps":
				predicates.add(HandsetPredicateUtil.isGpsContain(entry.getValue()));
				break;
			case "battery":
				predicates.add(HandsetPredicateUtil.isBatteryContain(entry.getValue()));
				break;
			}
		});

		LOGGER.info("generate - no of predicates {}", predicates.size());

		return predicates;
	}
}
