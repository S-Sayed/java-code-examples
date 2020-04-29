package com.ssayed.examples.structural.bridge;

import com.ssayed.examples.structural.bridge.abstraction.remote.AdvancedRemote;
import com.ssayed.examples.structural.bridge.abstraction.remote.BasicRemote;
import com.ssayed.examples.structural.bridge.abstraction.remote.Remote;
import com.ssayed.examples.structural.bridge.implementation.device.Device;
import com.ssayed.examples.structural.bridge.implementation.device.TV;

public class BridgeExample {

	public static void main(String[] args) {
		System.out.println("|-------- TV -----------|");
		System.out.println("|-----------------------|");

		Device device = new TV();

		System.out.println("|------- Basic Remote ---------|");
		System.out.println("|------------------------------|");

		Remote remote = new BasicRemote(device);
		for (int i = 0; i < 5; i++) {
			remote.power();
			remote.nextChannel();
			remote.volumeUp();
			device.printDetails();
		}

		System.out.println("|------- Advanced Remote ---------|");
		System.out.println("|---------------------------------|");

		AdvancedRemote advancedRemote = new AdvancedRemote(device);
		advancedRemote.mute();
		advancedRemote.nextChannel();
		device.printDetails();
	}
}
