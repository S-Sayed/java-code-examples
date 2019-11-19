package com.mockito.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mockito.example.service.CustomerProfileService;
import com.mockito.example.service.EmailNotificationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerProfileServiceTest {

	@Autowired
	CustomerProfileService customerProfileService;

	@MockBean
	EmailNotificationService emailNotificationService;

	@Test
	public void whenEmailIdIsProvided_thenSendEmail_AndReturnTrue() {
		String emailId = "sameh@sameh.com";
		when(emailNotificationService.send(emailId)).thenReturn(true);
		boolean returned = customerProfileService.sendEmail(emailId);
		boolean expected = true;
		assertEquals(returned, expected);
		// make sure that the send method called once
		verify(emailNotificationService, times(1)).send(emailId);
		// make sure that emailNotificationService not called anymore after send
		// method that called once
		verifyNoMoreInteractions(emailNotificationService);
	}

	@Test
	public void whenEmailIdIsMissing_thenReturnFalse() {
		String emailId = null;
		when(emailNotificationService.send(emailId)).thenReturn(false);
		boolean returned = customerProfileService.sendEmail(emailId);
		boolean expected = false;
		assertEquals(returned, expected);
		verify(emailNotificationService, times(1)).send(emailId);
	}
}
