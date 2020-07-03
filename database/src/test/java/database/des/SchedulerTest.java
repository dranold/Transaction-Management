package database.des;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		scheduler.start(Arrays.asList(new Event(2,scheduler),new Event(0,scheduler), new CancelEvent(100000, scheduler)));
	}
	
	/**
	 * 3c
	 */
	@Test
	void test3() {
		Scheduler scheduler = new Scheduler();
		scheduler.start(Arrays.asList(new Event(0, scheduler), new CancelEvent(1000000, scheduler))); //Erwartet 200000 Events
	}
	
	/**
	 * 3d
	 */
	@Test
	void test4() {
		List<Integer> allSchedulerRes = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			Scheduler scheduler = new Scheduler();
			allSchedulerRes.add(scheduler.start(Arrays.asList(new Event(0, scheduler), new CancelEvent(10000, scheduler))));
		}
		System.out.println(allSchedulerRes);
	}
}
