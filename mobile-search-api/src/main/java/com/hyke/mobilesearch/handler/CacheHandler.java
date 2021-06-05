package com.hyke.mobilesearch.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.hyke.mobilesearch.annotation.Log;
import com.hyke.mobilesearch.dao.MobileDAO;
import com.hyke.mobilesearch.model.Handset;

@Component
public class CacheHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheHandler.class);

	@Autowired
	private MobileDAO mobileDAO;

	@Cacheable(value = "handsets")
	@Log
	public List<Handset> getAllHandsets() {
		LOGGER.info("get all handsets ... ");
		return mobileDAO.findAll();
	}
}
