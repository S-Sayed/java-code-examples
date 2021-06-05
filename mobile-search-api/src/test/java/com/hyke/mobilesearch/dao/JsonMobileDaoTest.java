package com.hyke.mobilesearch.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.hyke.mobilesearch.MobileSearchTest;
import com.hyke.mobilesearch.model.Handset;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonMobileDaoTest extends MobileSearchTest {

	@Autowired
	private JsonMobileDAO jsonMobileDAO;

	@MockBean
	private RestTemplate restTemplate;

	@Value("${mobile.handsets.service.url}")
	private String mobileHandsetServicesUrl;

	@Test
	public void givenNothing_whenGettingHandsets_thenReturnAll() throws Exception {
		List<Handset> handsets = create5Handsets();
		Handset[] handsetsArray = new Handset[handsets.size()];
		handsetsArray = handsets.toArray(handsetsArray);

		Mockito.when(restTemplate.getForEntity(mobileHandsetServicesUrl, Handset[].class))
				.thenReturn(new ResponseEntity<Handset[]>(handsetsArray, HttpStatus.OK));

		List<Handset> returnedHandsets = jsonMobileDAO.findAll();

		assertNotNull(returnedHandsets);
		assertThat(returnedHandsets.size()).isEqualTo(handsets.size());
		assertThat(returnedHandsets.get(0).getBrand()).isEqualTo(handsets.get(0).getBrand());
		verify(restTemplate).getForEntity(mobileHandsetServicesUrl, Handset[].class);
	}
}