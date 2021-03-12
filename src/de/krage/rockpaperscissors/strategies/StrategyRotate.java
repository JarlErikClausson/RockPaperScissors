package de.krage.rockpaperscissors.strategies;

import de.krage.rockpaperscissors.Constants;
import de.krage.rockpaperscissors.choices.Choice;
import de.krage.rockpaperscissors.choices.Paper;
import de.krage.rockpaperscissors.choices.Rock;
import de.krage.rockpaperscissors.choices.Scissors;

public class StrategyRotate implements Strategy{

	/**
	 * Rotates the choices in the order Rock -> Paper -> Scissors -> Rock -> ...
	 * @param pPrevOwn This players last choice
	 * @param pPrevOpponent The opponents last choice (not used here)
	 * @return The strategies choice
	 */
	@Override
	public Choice getNextChoice(Choice pPrevOwn, Choice pPrevOpponent) {
		Choice lChoice;
		if(pPrevOwn == null || pPrevOwn instanceof Scissors)
			lChoice = new Rock();
		else if(pPrevOwn instanceof Rock)
			lChoice = new Paper();
		else
			lChoice = new Scissors();
		return lChoice;
	}
}
