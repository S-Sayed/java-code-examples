package com.ssayed.examples.structural.bridge.implementation.device;

//concrete implementor
public class TV implements Device {

	private boolean on = false;
	private int volume = 1;
	private int channel = 1;

	@Override
	public boolean isOn() {
		return on;
	}

	@Override
	public void powerOn() {
		on = true;
	}

	@Override
	public void powerOff() {
		on = false;
	}

	@Override
	public void nextChannel() {
		if (channel > 10)
			channel = 10;
		else
			channel += 1;
	}

	@Override
	public void previousChannel() {
		if (channel < 0)
			channel = 0;
		else
			channel -= 1;
	}

	@Override
	public void volumeUp() {
		if (volume > 100)
			volume = 100;
		else
			volume += 1;
	}

	@Override
	public void volumDown() {
		if (volume < 0)
			volume = 0;
		else
			volume -= 1;
	}

	@Override
	public void setVolume(int volume) {
		this.volume = 0;
	}

	@Override
	public void printDetails() {
		System.out.println("status is <" + (on ? "ON" : "OFF") + ">, with volume= <" + volume + ">, with channel= <"
				+ channel + ">");

	}
}
