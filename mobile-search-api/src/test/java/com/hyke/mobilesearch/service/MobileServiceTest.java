package com.hyke.mobilesearch.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hyke.mobilesearch.MobileSearchTest;
import com.hyke.mobilesearch.handler.CacheHandler;
import com.hyke.mobilesearch.model.Handset;

@RunWith(MockitoJUnitRunner.class)
public class MobileServiceTest extends MobileSearchTest {

	@InjectMocks
	private MobileService mobileService;

	@Mock
	private CacheHandler cacheHandler;

	@Test
	public void givenNoSearchCriteria_whenGettingHandsets_thenReturnAll() throws Exception {
		List<Handset> handsets = create5Handsets();
		Mockito.when(cacheHandler.getAllHandsets()).thenReturn(handsets);

		List<Handset> returnedHandsets = mobileService.getHandsets(new HashMap<>());

		assertNotNull(returnedHandsets);
		assertThat(returnedHandsets.size()).isEqualTo(handsets.size());
		assertThat(returnedHandsets.get(0).getBrand()).isEqualTo(handsets.get(0).getBrand());
		verify(cacheHandler).getAllHandsets();
	}

	@Test
	public void givenValidSearchCriteria_whenGettingHandsets_thenReturnMatched() throws Exception {
		int handsetId = 1;
		List<Handset> handsets = new ArrayList<>();
		handsets.add(createHandsetObject(handsetId));

		Mockito.when(cacheHandler.getAllHandsets()).thenReturn(handsets);

		Map<String, String> criteria = new HashMap<>();
		criteria.put("brand", "Brand-1");
		List<Handset> returnedHandsets = mobileService.getHandsets(criteria);

		assertNotNull(returnedHandsets);
		assertThat(returnedHandsets.size()).isEqualTo(handsets.size());
		assertThat(returnedHandsets.get(0).getBrand()).isEqualTo(handsets.get(0).getBrand());
		verify(cacheHandler).getAllHandsets();
	}

	@Test
	public void givenInvalidSearchCriteria_whenGettingHandsets_thenReturnEmpty() throws Exception {
		List<Handset> handsets = create5Handsets();
		Mockito.when(cacheHandler.getAllHandsets()).thenReturn(handsets);

		Map<String, String> criteria = new HashMap<>();
		criteria.put("brand", "none");
		List<Handset> returnedHandsets = mobileService.getHandsets(criteria);

		assertNotNull(returnedHandsets);
		assertThat(returnedHandsets.size()).isEqualTo(0);
		verify(cacheHandler).getAllHandsets();
	}
}
