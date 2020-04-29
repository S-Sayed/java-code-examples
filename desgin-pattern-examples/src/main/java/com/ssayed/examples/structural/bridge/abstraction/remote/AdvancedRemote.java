package com.ssayed.examples.structural.bridge.abstraction.remote;

import com.ssayed.examples.structural.bridge.implementation.device.Device;

//Refine abstraction
public class AdvancedRemote extends BasicRemote {

	public AdvancedRemote(Device device) {
		super(device);
	}

	public void mute() {
		device.setVolume(0);
	}
}