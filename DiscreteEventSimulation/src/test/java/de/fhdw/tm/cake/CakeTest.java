package de.fhdw.tm.cake;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import de.fhdw.tm.des.modelling.ModelProcess;
import de.fhdw.tm.des.scheduler.DESScheduler;
import de.fhdw.tm.des.scheduler.Simulation;
import de.fhdw.tm.des.scheduler.Simulator;

public class CakeTest {

	@Test
	public void bakeCakes() {
		this.bakeCakes(0, 1, 15, true);
	}

	private void bakeCakes(int seed, int simulations, int numberOfCakes, boolean debug) {

		try {
			DESScheduler.setDebug(debug);

			Simulator simulator = new Simulator(seed);

			Simulation sim = new Simulation() {

				@Override
				public void start() {
					System.out.println("Start baking!");
				}

				@Override
				public void injectStart() {
					for (int i = 0; i < numberOfCakes; i++) {
						DESScheduler.schedule(new ModelProcess(new Cake()), 0);
					}
				}

				@Override
				public void finish() {
					System.out.println("End baking!");
				}
			};

			for (int i = 0; i < simulations; i++) {
				simulator.simulate(sim);
			}

			simulator.terminate();
		} catch (Exception e) {
			fail("Baking Cakes failed!");
		}
	}

}
