package com.hyke.mobilesearch.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hyke.mobilesearch.model.Handset;

@Component
public interface MobileDAO {

	public abstract List<Handset> findAll();
}
