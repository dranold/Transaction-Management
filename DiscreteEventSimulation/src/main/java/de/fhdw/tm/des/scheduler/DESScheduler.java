package de.fhdw.tm.des.scheduler;

import org.apache.commons.math3.random.RandomGenerator;

public abstract class DESScheduler {

	private static boolean debug = false;

	private static DESScheduler singleton = new DirectScheduler();

	protected static DESScheduler getScheduler(){
		return singleton;
	}
	
	public static void schedule(DESOperation operation, long time) {
		singleton.inject(operation, time);
	}
	
	public static void scheduleToFuture(DESOperation operation, long time) {
		singleton.injectToFuture(operation, time);
	}
	
	public static void scheduleToFuture(DESOperation event, double time) {
		singleton.injectToFuture(event, (long)(time + 1));
	}
	
	public static long getSimulationTime() {
		return singleton.getTime();
	}
	
	public static RandomGenerator getRandom() {
		return singleton.getRandomGenerator();
	}	
	
	protected abstract void inject(DESOperation operation, long time);

	protected abstract void injectToFuture(DESOperation operation, long time);
	
	protected abstract long getTime();

	protected abstract RandomGenerator getRandomGenerator();

	protected abstract void reset(RandomGenerator randomGenerator);
	
	public abstract void execute(Simulation sim, RandomGenerator randomGenerator);

	public static void log(String message) {
		if(debug) {
			System.out.println(message);
		}
	}
	
	public static void log(String message, boolean error) {
		if(debug) {
			if(error) {
				System.err.println(message);		
			}else {
				System.out.println(message);	
			}
		}
	}
	
	public static void setDebug(boolean enabled) {
		DESScheduler.debug = enabled;
	}

	
}