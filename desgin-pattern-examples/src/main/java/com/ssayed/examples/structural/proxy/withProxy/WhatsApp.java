package com.ssayed.examples.structural.proxy.withProxy;

import java.util.List;

interface WhatsApp {
	List<byte[]> getPhotosByCustomerId(long customerId);
}