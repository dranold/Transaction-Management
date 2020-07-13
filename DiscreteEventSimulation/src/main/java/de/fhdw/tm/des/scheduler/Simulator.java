package de.fhdw.tm.des.scheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.random.MersenneTwister;

public class Simulator {

	private MersenneTwister rootRandom;
	private ExecutorService executor;

	public Simulator(long mainSeed) {
		this(mainSeed, Runtime.getRuntime().availableProcessors());
	}
	
	public Simulator(long mainSeed, int threads) {
		this.rootRandom = new MersenneTwister(mainSeed);

		executor = Executors.newFixedThreadPool(1); //TODO True multisim ;)
	}
	
	public void terminate() throws InterruptedException {
		this.executor.shutdown();
		this.executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	}
	
	public void simulate(Simulation sim) {
		this.executor.execute(new SimulationWrapper(sim, rootRandom.nextLong()));
	}
	
}
