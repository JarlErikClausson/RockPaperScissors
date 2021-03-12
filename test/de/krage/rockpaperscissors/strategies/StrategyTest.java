package de.krage.rockpaperscissors.strategies;

import de.krage.rockpaperscissors.choices.Paper;
import de.krage.rockpaperscissors.choices.Rock;
import de.krage.rockpaperscissors.choices.Scissors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {

	@Test
	public void testAlwaysRock(){
		Strategy strategyAlwaysRock = new StrategyAlwaysRock();
		assertTrue(strategyAlwaysRock.getNextChoice(null, null) instanceof Rock);
		assertTrue(strategyAlwaysRock.getNextChoice(null, null) instanceof Rock);
		assertTrue(strategyAlwaysRock.getNextChoice(null, null) instanceof Rock);
		assertTrue(strategyAlwaysRock.getNextChoice(null, null) instanceof Rock);
		assertTrue(strategyAlwaysRock.getNextChoice(null, null) instanceof Rock);
	}

	@Test
	public void testAlwaysPaper(){
		Strategy strategyAlwaysPaper = new StrategyAlwaysPaper();
		assertTrue(strategyAlwaysPaper.getNextChoice(null, null) instanceof Paper);
		assertTrue(strategyAlwaysPaper.getNextChoice(null, null) instanceof Paper);
		assertTrue(strategyAlwaysPaper.getNextChoice(null, null) instanceof Paper);
		assertTrue(strategyAlwaysPaper.getNextChoice(null, null) instanceof Paper);
		assertTrue(strategyAlwaysPaper.getNextChoice(null, null) instanceof Paper);
	}

	@Test
	public void testAlwaysScissors(){
		Strategy strategyAlwaysScissors = new StrategyAlwaysScissors();
		assertTrue(strategyAlwaysScissors.getNextChoice(null, null) instanceof Scissors);
		assertTrue(strategyAlwaysScissors.getNextChoice(null, null) instanceof Scissors);
		assertTrue(strategyAlwaysScissors.getNextChoice(null, null) instanceof Scissors);
		assertTrue(strategyAlwaysScissors.getNextChoice(null, null) instanceof Scissors);
		assertTrue(strategyAlwaysScissors.getNextChoice(null, null) instanceof Scissors);
	}

	@Test
	public void testCopycat(){
		Strategy strategyCopycat = new StrategyCopycat();
		assertTrue(strategyCopycat.getNextChoice(null, new Rock()) instanceof Rock);
		assertTrue(strategyCopycat.getNextChoice(null, new Rock()) instanceof Rock);
		assertTrue(strategyCopycat.getNextChoice(null, new Paper()) instanceof Paper);
		assertTrue(strategyCopycat.getNextChoice(null, new Paper()) instanceof Paper);
		assertTrue(strategyCopycat.getNextChoice(null, new Scissors()) instanceof Scissors);
		assertTrue(strategyCopycat.getNextChoice(null, new Scissors()) instanceof Scissors);
	}

	@Test
	public void testRotate(){
		Strategy strategyRotate = new StrategyRotate();
		assertTrue(strategyRotate.getNextChoice(null, null) instanceof Rock);
		assertTrue(strategyRotate.getNextChoice(new Rock(), null) instanceof Paper);
		assertTrue(strategyRotate.getNextChoice(new Paper(), null) instanceof Scissors);
		assertTrue(strategyRotate.getNextChoice(new Scissors(), null) instanceof Rock);
	}
}