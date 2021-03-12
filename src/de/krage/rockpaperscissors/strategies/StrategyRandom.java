package de.krage.rockpaperscissors.strategies;

import de.krage.rockpaperscissors.Constants;
import de.krage.rockpaperscissors.choices.Choice;
import de.krage.rockpaperscissors.choices.Paper;
import de.krage.rockpaperscissors.choices.Rock;
import de.krage.rockpaperscissors.choices.Scissors;

public class StrategyRandom implements Strategy{

	/**
	 * Using a randomly generated number each of the three possible choices is chosen roughly 1/3 of the time.
	 * @param pPrevOwn This players last choice (not used here)
	 * @param pPrevOpponent The opponents last choice (not used here)
	 * @return The strategies choice
	 */
	@Override
	public Choice getNextChoice(Choice pPrevOwn, Choice pPrevOpponent) {
		double lRandomNumber = Math.random();
		Choice pResult;
		if(lRandomNumber <= (1.0/3.0))
			pResult = new Rock();
		else if (lRandomNumber >= (2.0/3.0))
			pResult = new Scissors();
		else
			pResult = new Paper();
		return pResult;
	}
}
