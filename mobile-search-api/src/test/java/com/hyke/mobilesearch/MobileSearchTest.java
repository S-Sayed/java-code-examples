package com.hyke.mobilesearch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.hyke.mobilesearch.model.Handset;

public class MobileSearchTest {

	protected List<Handset> create5Handsets() {
		List<Handset> handsets = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			handsets.add(createHandsetObject(i));
		}

		return handsets;
	}

	protected Handset createHandsetObject(int handsetId) {
		Handset handset = new Handset();
		handset.setId(handsetId);
		handset.setBrand("Brand-" + handsetId);
		handset.setPhone("Phone-" + handsetId);
		handset.setPicture("https://cdn2.gsmarena.com/vv/bigpic/device-" + handsetId + ".jpg");
		handset.setRelease(new Handset.Release());
		handset.getRelease().setAnnounceDate(handsetId % 2 == 0 ? "2021 June" : "2020 October");
		handset.getRelease().setPriceEur(new BigDecimal(handsetId * 200));
		handset.setHardware(new Handset.Hardware());
		handset.getHardware().setAudioJack(handsetId % 2 == 0 ? "Yes" : "No");
		handset.getHardware().setGps(handsetId % 2 == 0 ? "Yes" : "No");
		handset.getHardware().setBattery(handsetId % 2 == 0 ? "5000" : "6000");
		return handset;
	}
}
