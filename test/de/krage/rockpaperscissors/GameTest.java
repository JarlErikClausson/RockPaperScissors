package de.krage.rockpaperscissors;

import de.krage.rockpaperscissors.choices.Paper;
import de.krage.rockpaperscissors.choices.Rock;
import de.krage.rockpaperscissors.choices.Scissors;
import de.krage.rockpaperscissors.strategies.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

	Game mGame;

	@BeforeEach
	public void initGame(){
		mGame = new Game();
	}

	@Test
	public void testCorrectInit(){
		Map<Integer, Integer> lTestMap = new HashMap<>();
		mGame.initResultMap(lTestMap);
		assertEquals(0, lTestMap.get(-1));
		assertEquals(0, lTestMap.get(0));
		assertEquals(0, lTestMap.get(1));
	}


	// Tests for the fight resolve mechanic

	@Test
	public void testRockVSRock(){
		assertEquals(0, mGame.resolveRound(new Rock(), new Rock()));
	}

	@Test
	public void testRockVSPaper(){
		assertEquals(-1, mGame.resolveRound(new Rock(), new Paper()));
	}

	@Test
	public void testRockVSScissors(){
		assertEquals(1, mGame.resolveRound(new Rock(), new Scissors()));
	}

	@Test
	public void testPaperVSRock(){
		assertEquals(1, mGame.resolveRound(new Paper(), new Rock()));
	}

	@Test
	public void testPaperVSPaper(){
		assertEquals(0, mGame.resolveRound(new Paper(), new Paper()));
	}

	@Test
	public void testPaperVSScissors(){
		assertEquals(-1, mGame.resolveRound(new Paper(), new Scissors()));
	}

	@Test
	public void testScissorsVSRock(){
		assertEquals(-1, mGame.resolveRound(new Scissors(), new Rock()));
	}

	@Test
	public void testScissorsVSPaper(){
		assertEquals(1, mGame.resolveRound(new Scissors(), new Paper()));
	}

	@Test
	public void testScissorsVSScissors(){
		assertEquals(0, mGame.resolveRound(new Scissors(), new Scissors()));
	}

	@Test
	public void testRockVSNull(){ assertEquals(0, mGame.resolveRound(new Rock(), null)); }

	@Test
	public void testNullVSRock(){ assertEquals(0, mGame.resolveRound(null, new Rock())); }

	@Test
	public void testNullVSNull(){ assertEquals(0, mGame.resolveRound(null, null)); }


	// Tests for strategy selection

	@Test
	public void testSelectRandomWith1(){
		assertTrue(mGame.selectStrategy(1) instanceof StrategyRandom);
		assertTrue(mGame.selectStrategy(Constants.STRATEGY_NUMBER_RANDOM) instanceof StrategyRandom);
	}

	@Test
	public void testSelectAlwaysRockWith2(){
		assertTrue(mGame.selectStrategy(2) instanceof StrategyAlwaysRock);
		assertTrue(mGame.selectStrategy(Constants.STRATEGY_NUMBER_ALWAYS_ROCK) instanceof StrategyAlwaysRock);
	}

	@Test
	public void testSelectAlwaysPaperWith3(){
		assertTrue(mGame.selectStrategy(3) instanceof StrategyAlwaysPaper);
		assertTrue(mGame.selectStrategy(Constants.STRATEGY_NUMBER_ALWAYS_PAPER) instanceof StrategyAlwaysPaper);
	}

	@Test
	public void testSelectAlwaysScissorsWith4(){
		assertTrue(mGame.selectStrategy(4) instanceof StrategyAlwaysScissors);
		assertTrue(mGame.selectStrategy(Constants.STRATEGY_NUMBER_ALWAYS_SCISSORS) instanceof StrategyAlwaysScissors);
	}

	@Test
	public void testSelectRotateWith5(){
		assertTrue(mGame.selectStrategy(5) instanceof StrategyRotate);
		assertTrue(mGame.selectStrategy(Constants.STRATEGY_NUMBER_ROTATE) instanceof StrategyRotate);
	}

	@Test
	public void testSelectCopycatWith6(){
		assertTrue(mGame.selectStrategy(6) instanceof StrategyCopycat);
		assertTrue(mGame.selectStrategy(Constants.STRATEGY_NUMBER_COPYCAT) instanceof StrategyCopycat);
	}

	@Test
	public void testInvalidSelectNegative1RandomStrategy(){
		assertTrue(mGame.selectStrategy(-1) instanceof StrategyRandom);
		assertTrue(mGame.selectStrategy(17000) instanceof StrategyRandom);
	}
}