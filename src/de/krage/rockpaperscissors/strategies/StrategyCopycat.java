package de.krage.rockpaperscissors.strategies;

import de.krage.rockpaperscissors.Constants;
import de.krage.rockpaperscissors.choices.Choice;

public class StrategyCopycat implements Strategy{

	/**
	 * Copies the opponents actions, starts with a random choice
	 * @param pPrevOwn This players last choice (not used here)
	 * @param pPrevOpponent The opponents last choice
	 * @return The strategies choice
	 */
	@Override
	public Choice getNextChoice(Choice pPrevOwn, Choice pPrevOpponent) {
		return pPrevOpponent == null
				? new StrategyRandom().getNextChoice(null, null)
				: pPrevOpponent;
	}
}
