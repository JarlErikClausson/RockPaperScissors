package de.krage.rockpaperscissors.strategies;

import de.krage.rockpaperscissors.choices.Choice;

public interface Strategy {
	/**
	 * @param pPrevOwn This players last choice (not required for each strategy)
	 * @param pPrevOpponent The opponents last choice (not required for each strategy)
	 * @return The strategies next choice
	 */
	Choice getNextChoice(Choice pPrevOwn, Choice pPrevOpponent);
}
