package de.krage.rockpaperscissors.strategies;

import de.krage.rockpaperscissors.Constants;
import de.krage.rockpaperscissors.choices.Choice;
import de.krage.rockpaperscissors.choices.Rock;

public class StrategyAlwaysRock implements Strategy {

	/**
	 * Chooses only Rock
	 * @param pPrevOwn This players last choice (not used here)
	 * @param pPrevOpponent The opponents last choice (not used here)
	 * @return The strategies choice
	 */
	@Override
	public Choice getNextChoice(Choice pPrevOwn, Choice pPrevOpponent) {
		return new Rock();
	}
}
