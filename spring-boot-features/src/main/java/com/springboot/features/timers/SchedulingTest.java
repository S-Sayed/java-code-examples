package com.springboot.features.timers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component // important if you will add the scheduling tasks in separate class
public class SchedulingTest {

	private static final Logger log = LoggerFactory.getLogger(SchedulingTest.class);

	// execute the below task every 3 seconds, will start after the app is up
	// and running, and will not wait the completion of the previous task

	@Scheduled(fixedRate = 3000)
	public void scheduleTest() {
		log.info("Fixed Rate START");
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// execute the below task every 3 seconds and the task will wait the
	// completion of previous one, so in the below example
	// every method will complete its work every 11 seconds (3 seconds + 8
	// seconds in the thread sleep)

	@Scheduled(fixedDelay = 3000, initialDelay = 5000)
	public void scheduleTest2() {
		log.info("Fixed Delay 2 START");

		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
