package com.ssayed.examples.structural.bridge.abstraction.remote;

import com.ssayed.examples.structural.bridge.implementation.device.Device;

//Refine abstraction
public class BasicRemote implements Remote {

	protected Device device;

	public BasicRemote(Device device) {
		this.device = device;
	}

	@Override
	public void power() {
		if (device.isOn())
			device.powerOff();
		else
			device.powerOn();
	}

	@Override
	public void nextChannel() {
		device.nextChannel();
	}

	@Override
	public void previousChannel() {
		device.previousChannel();
	}

	@Override
	public void volumeUp() {
		device.volumeUp();
	}

	@Override
	public void volumeDown() {
		device.volumDown();
	}
}