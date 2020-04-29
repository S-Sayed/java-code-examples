package com.ssayed.examples.structural.bridge.implementation.device;

// implementor
public interface Device {

	boolean isOn();

	void powerOn();

	void powerOff();

	void nextChannel();

	void previousChannel();

	void volumeUp();

	void volumDown();

	void printDetails();

	void setVolume(int volume);
}