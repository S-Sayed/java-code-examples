package com.hyke.mobilesearch.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hyke.mobilesearch.MobileSearchTest;
import com.hyke.mobilesearch.exception.NoHandsetsFoundException;
import com.hyke.mobilesearch.model.Handset;
import com.hyke.mobilesearch.service.MobileService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MobileControllerTest extends MobileSearchTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MobileService mobileService;

	@Test
	public void givenNoSearchCriteria_whenGettingHandsets_thenReturnAll() throws Exception {
		List<Handset> handsets = create5Handsets();
		Mockito.when(mobileService.getHandsets(new HashMap<String, String>())).thenReturn(handsets);

		mockMvc.perform(get("/mobile/search").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.handsets", hasSize(handsets.size())))
				.andExpect(jsonPath("$.handsets[0].brand", is(handsets.get(0).getBrand())));
	}

	@Test
	public void givenInvalidSearchCriteria_whenNoHandsets_thenThrowException() throws Exception {
		Map<String, String> criteria = new HashMap<>();
		criteria.put("brand", "none");
		Mockito.doThrow(new NoHandsetsFoundException(criteria)).when(mobileService).getHandsets(criteria);

		mockMvc.perform(get("/mobile/search?brand=none").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	public void givenValidSearchCriteria_whenGettingHandsets_thenReturnMatched() throws Exception {
		Map<String, String> criteria = new HashMap<>();
		criteria.put("brand", "Brand-1");

		int handsetId = 1;
		List<Handset> handsets = new ArrayList<>();
		handsets.add(createHandsetObject(handsetId));

		Mockito.when(mobileService.getHandsets(criteria)).thenReturn(handsets);

		mockMvc.perform(get("/mobile/search?brand=Brand-1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.handsets", hasSize(1)))
				.andExpect(jsonPath("$.handsets[0].brand", is(handsets.get(0).getBrand())));
	}
}
