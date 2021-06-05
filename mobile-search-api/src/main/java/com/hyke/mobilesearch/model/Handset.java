package com.hyke.mobilesearch.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Handset {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("brand")
	private String brand;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("picture")
	private String picture;

	@JsonProperty("release")
	private Release release;

	@JsonProperty("sim")
	private String sim;

	@JsonProperty("resolution")
	private String resolution;

	@JsonProperty("hardware")
	private Hardware hardware;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Hardware getHardware() {
		return hardware;
	}

	public void setHardware(Hardware hardware) {
		this.hardware = hardware;
	}

	public static class Hardware {
		@JsonProperty("audioJack")
		private String audioJack;

		@JsonProperty("gps")
		private String gps;

		@JsonProperty("battery")
		private String battery;

		public String getAudioJack() {
			return audioJack;
		}

		public void setAudioJack(String audioJack) {
			this.audioJack = audioJack;
		}

		public String getGps() {
			return gps;
		}

		public void setGps(String gps) {
			this.gps = gps;
		}

		public String getBattery() {
			return battery;
		}

		public void setBattery(String battery) {
			this.battery = battery;
		}
	}

	public static class Release {
		@JsonProperty("announceDate")
		private String announceDate;

		@JsonProperty("priceEur")
		private BigDecimal priceEur;

		public String getAnnounceDate() {
			return announceDate;
		}

		public void setAnnounceDate(String announceDate) {
			this.announceDate = announceDate;
		}

		public BigDecimal getPriceEur() {
			return priceEur;
		}

		public void setPriceEur(BigDecimal priceEur) {
			this.priceEur = priceEur;
		}
	}
}