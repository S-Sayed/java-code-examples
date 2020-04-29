package com.ssayed.examples.structural.adapter;

import com.ssayed.examples.structural.adapter.model.SocialMediaType;
import com.ssayed.examples.structural.adapter.model.Table;

interface ActionHandler {
	Table execute(SocialMediaType socialMediaType, String username);
}