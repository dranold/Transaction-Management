package database.des;

import java.util.Random;

import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;

public class Event implements Command {
	private long timestamp;
	
	private static RandomGenerator rand1 = RandomGeneratorFactory.createRandomGenerator(new Random());
	private static ExponentialDistribution exp1 = new ExponentialDistribution(rand1, 10); 
	private static RandomGenerator rand2 = RandomGeneratorFactory.createRandomGenerator(new Random((int)exp1.sample()));
	private static ExponentialDistribution exp2 = new ExponentialDistribution(rand2, 10);
	
	Scheduler scheduler;
	
	public Event(long timestamp, Scheduler scheduler) {
		this.timestamp = timestamp;
		this.scheduler = scheduler;
	}
	
	public long getTimestamp() {
		return this.timestamp;
	}
	
	public void setTimestamp(long newTimestamp) {
		this.timestamp = newTimestamp;
	}
	
	public void execute() { 
		long timeInFuture = (long) exp2.sample();
		this.scheduler.scheduleInFuture(this, timeInFuture);
	}
	
	public String toString() {
		return String.valueOf(timestamp);
	}
}
