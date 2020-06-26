package database.random;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class RandomTest {

	/**
	 * Exercise 1b,1c
	 * 
	 * Compares random generated values of two generators with the same seed.
	 */
	@Test
	void compareGenerators() {
		int values = 10, seed = 42;
		
		Random instance1 = new Random(seed), instance2 = new Random(seed);
		
		long[] values1 = instance1.longs(values).toArray(), values2 = instance2.longs(values).toArray();
		
		assertArrayEquals(values1, values2);
		
		for (int i = 0; i < values; i++) {
			System.out.println("["+i+"] -> ("+values1[i]+","+values2[i]+")");
		}
	}

}
