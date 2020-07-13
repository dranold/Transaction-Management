package de.fhdw.tm.cake;

import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;

import de.fhdw.tm.des.modelling.ProcessStep;
import de.fhdw.tm.des.modelling.ProcessStepDelay;
import de.fhdw.tm.des.scheduler.DESScheduler;

public class Cake {

	private static Integer instances = 0;
	private Integer id;

	public Cake() {
		synchronized (instances) {
			this.id = instances;
			instances++;
		}
	}

	@ProcessStepDelay(0)
	public long readRecipyDelay() {
		RealDistribution dist = new NormalDistribution(DESScheduler.getRandom(), 500, 200);
		double current;
		while ((current = dist.sample()) < 0)
			;
		return (long) current;
	}

	@ProcessStep(0)
	public void readRecipy() {
		DESScheduler.log(this.id + ": reading recipy!");
	}

	@ProcessStepDelay(1)
	public long buyDelay() {
		return (long) new ExponentialDistribution(DESScheduler.getRandom(), 7500).sample();
	}

	@ProcessStep(1)
	public void buy() {
		DESScheduler.log(this.id + ": buying!");
	}

	@ProcessStepDelay(2)
	public long weighDelay() {
		return (long) new UniformRealDistribution(DESScheduler.getRandom(), 100, 200).sample();
	}

	@ProcessStep(2)
	public void weigh() {
		DESScheduler.log(this.id + ": weighing!");
	}

	@ProcessStepDelay(3)
	public long mixDelay() {
		RealDistribution dist = new NormalDistribution(DESScheduler.getRandom(), 100, 5);
		double current;
		while ((current = dist.sample()) < 0)
			;
		return (long) current;
	}

	@ProcessStep(3)
	public void mix() {
		DESScheduler.log(this.id + ": mixing!");
	}

	@ProcessStepDelay(4)
	public long bakeDelay() {
		return 1000;
	}

	@ProcessStep(4)
	public void bake() {
		DESScheduler.log(this.id + ": baking!");
	}
}
