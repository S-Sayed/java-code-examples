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

			String value = entry.getValue().trim();

			switch (entry.getKey().toLowerCase()) {
			case "id":
				predicates.add(HandsetPredicateUtil.isIdEqual(Integer.parseInt(value)));
				break;
			case "brand":
				predicates.add(HandsetPredicateUtil.isBrandEqual(value));
				break;
			case "phone":
				predicates.add(HandsetPredicateUtil.isPhoneContain(value));
				break;
			case "picture":
				predicates.add(HandsetPredicateUtil.isPictureContain(value));
				break;
			case "announcedate":
				predicates.add(HandsetPredicateUtil.isAnnounceDateContain(value));
				break;
			case "priceeur":
				predicates.add(HandsetPredicateUtil.isPriceEurEqual(new BigDecimal(value)));
				break;
			case "sim":
				predicates.add(HandsetPredicateUtil.isSimContain(value));
				break;
			case "resolution":
				predicates.add(HandsetPredicateUtil.isResolutionContain(value));
				break;
			case "audiojack":
				predicates.add(HandsetPredicateUtil.isAudioJackEqual(value));
				break;
			case "gps":
				predicates.add(HandsetPredicateUtil.isGpsContain(value));
				break;
			case "battery":
				predicates.add(HandsetPredicateUtil.isBatteryContain(value));
				break;
			}
		});

		LOGGER.info("generate - no of predicates {}", predicates.size());

		return predicates;
	}
}
