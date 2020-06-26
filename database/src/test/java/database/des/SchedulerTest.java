package database.des;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SchedulerTest {

	/**
	 * 2a - 2c
	 */
	@Test
	void test1() {
		Scheduler scheduler = new Scheduler();
		scheduler.start(Arrays.asList(new Event(0,scheduler)));
	}
	
	
	/**
	 * 2d
	 */
	@Test
	void test2() {
		Scheduler scheduler = new Scheduler();
		scheduler.start(Arrays.asList(new Event(2,scheduler),new Event(0,scheduler)));
	}
}
