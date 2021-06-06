package com.hyke.mobilesearch.predicate;

import java.math.BigDecimal;
import java.util.function.Predicate;

import com.hyke.mobilesearch.model.Handset;

public class HandsetPredicateUtil {

	public static Predicate<Handset> isIdEqual(Integer id) {
		return device -> device.getId().intValue() == id.intValue();
	}

	public static Predicate<Handset> isBrandEqual(String brand) {
		return device -> device.getBrand().equalsIgnoreCase(brand);
	}

	public static Predicate<Handset> isPhoneContain(String phone) {
		return device -> device.getPhone().toUpperCase().contains(phone.toUpperCase());
	}

	public static Predicate<Handset> isPictureContain(String picture) {
		return device -> device.getPicture().toUpperCase().contains(picture.toUpperCase());
	}

	public static Predicate<Handset> isAnnounceDateContain(String announceDate) {
		return device -> device.getRelease().getAnnounceDate().contains(announceDate);
	}

	public static Predicate<Handset> isPriceEurEqual(BigDecimal priceEur) {
		return device -> device.getRelease().getPriceEur().doubleValue() == priceEur.doubleValue();
	}

	public static Predicate<Handset> isSimContain(String sim) {
		return device -> device.getSim().toUpperCase().contains(sim.toUpperCase());
	}

	public static Predicate<Handset> isResolutionContain(String resolution) {
		return device -> device.getResolution().contains(resolution);
	}

	public static Predicate<Handset> isAudioJackEqual(String audioJack) {
		return device -> device.getHardware().getAudioJack().equalsIgnoreCase(audioJack);
	}

	public static Predicate<Handset> isGpsContain(String gps) {
		return device -> device.getHardware().getGps().toUpperCase().contains(gps.toUpperCase());
	}

	public static Predicate<Handset> isBatteryContain(String battery) {
		return device -> device.getHardware().getBattery().toUpperCase().contains(battery.toUpperCase());
	}
}