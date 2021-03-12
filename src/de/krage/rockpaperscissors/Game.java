package de.krage.rockpaperscissors;

import de.krage.rockpaperscissors.choices.Choice;
import de.krage.rockpaperscissors.strategies.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

	private final Scanner mScanner = new Scanner(System.in);

	/**
	 * Starts the game
	 */
	public void run() {
		System.out.print(Constants.DIALOGUE_INTRO);

		int lRounds = selectNumberOfRounds();
		Strategy lStrategyA = selectStrategyDialogue(true);
		Strategy lStrategyB = selectStrategyDialogue(false);

		play(lStrategyA, lStrategyB, lRounds);

		System.out.println(Constants.DIALOGUE_OUTRO);
	}

	/**
	 * Method for receiving the number count
	 * @return the number of rounds to simulate
	 */
	public int selectNumberOfRounds(){
		System.out.print(Constants.DIALOGUE_SELECT_NR_ROUNDS);

		int lRounds;
		String lInput = mScanner.next();

		try{
			lRounds = Integer.parseInt(lInput);
		} catch(NumberFormatException ex){
			System.err.println(Constants.DIALOGUE_WRONG_INPUT);
			lRounds = selectNumberOfRounds();
		}

		if(lRounds <= 0){
			System.err.println(Constants.DIALOGUE_WRONG_INPUT);
			lRounds = selectNumberOfRounds();
		}

		return lRounds;
	}

	/**
	 * Initiates the strategy selection dialogue
	 * @param pFirstPlayer true for Player A dialogue, false for Player B dialogue
	 * @return the selected strategy
	 */
	public Strategy selectStrategyDialogue(boolean pFirstPlayer){
		Strategy lStrategy;
		if(pFirstPlayer)
			System.out.print(Constants.DIALOGUE_SELECT_PLAYER_A);
		else
			System.out.print(Constants.DIALOGUE_SELECT_PLAYER_B);

		displayStrategyOptions();

		int lStrategyCode;
		String lInput = mScanner.next();
		if(lInput.isEmpty())
			lInput = "1";

		try{
			lStrategyCode = Integer.parseInt(lInput);
		} catch (NumberFormatException ex){
			System.err.println(Constants.DIALOGUE_WRONG_INPUT);
			return selectStrategyDialogue(pFirstPlayer);
		}

		if(0 < lStrategyCode && lStrategyCode < 7) {
			lStrategy = selectStrategy(lStrategyCode);
		} else {
			System.err.println(Constants.DIALOGUE_WRONG_INPUT);
			lStrategy = selectStrategyDialogue(pFirstPlayer);
		}

		return lStrategy;
	}

	/**
	 * Selects a strategy from the given code
	 * @param pStrategyCode the numerical for selecting a code
	 * @return the selected strategy, chooses Random Picker for invalid codes
	 */
	public Strategy selectStrategy(int pStrategyCode){
		Strategy lStrategy;
		switch(pStrategyCode){
			case Constants.STRATEGY_NUMBER_ALWAYS_ROCK:
				lStrategy = new StrategyAlwaysRock();
				break;
			case Constants.STRATEGY_NUMBER_ALWAYS_PAPER:
				lStrategy = new StrategyAlwaysPaper();
				break;
			case Constants.STRATEGY_NUMBER_ALWAYS_SCISSORS:
				lStrategy = new StrategyAlwaysScissors();
				break;
			case Constants.STRATEGY_NUMBER_ROTATE:
				lStrategy = new StrategyRotate();
				break;
			case Constants.STRATEGY_NUMBER_COPYCAT:
				lStrategy = new StrategyCopycat();
				break;
			default:
				System.err.println(Constants.DIALOGUE_WRONG_STRATEGY_CODE);
			case Constants.STRATEGY_NUMBER_RANDOM:
				lStrategy = new StrategyRandom();
				break;
		}
		return lStrategy;
	}

	/**
	 * Initiates the play phase and returns its results
	 * @param pStrategyA the strategy for Player A
	 * @param pStrategyB the strategy for Player B
	 * @param pRounds the number of rounds to play
	 */
	public void play(Strategy pStrategyA, Strategy pStrategyB, int pRounds){
		if(pRounds <= 0){
			System.err.println(Constants.DIALOGUE_WRONG_INPUT);
			pRounds = selectNumberOfRounds();
		}
		System.out.printf(Constants.DIALOGUE_PROCESSING_GAME, pRounds);

		Choice lPrevChoiceA = null;
		Choice lPrevChoiceB = null;
		Choice lChoiceA;
		Choice lChoiceB;
		Map<Integer, Integer> lResultMap = new HashMap<>();

		initResultMap(lResultMap);

		int lRoundResult;
		for (int iRoundNr = 1; iRoundNr <= pRounds; iRoundNr++) {
			lChoiceA = pStrategyA.getNextChoice(lPrevChoiceA, lPrevChoiceB);
			lChoiceB = pStrategyB.getNextChoice(lPrevChoiceB, lPrevChoiceA);

			lRoundResult = resolveRound(lChoiceA, lChoiceB);
			lResultMap.put(lRoundResult, lResultMap.get(lRoundResult)+1);

			lPrevChoiceA = lChoiceA;
			lPrevChoiceB = lChoiceB;

			if(pRounds > 1000000)
				if(iRoundNr % 100000 == 0)
					System.out.printf((Constants.DIALOGUE_STEP_OF_TENTHOUSAND), iRoundNr);
		}

		System.out.printf(
				Constants.DIALOGUE_GAME_FINISHED,
				lResultMap.get(1),
				lResultMap.get(-1),
				lResultMap.get(0));
	}

	/**
	 *	Initializes the result map to save the results
	 * @param pResultMap the Map that is to be initialized
	 */
	public void initResultMap(Map<Integer, Integer> pResultMap){
		pResultMap.put(Constants.RESULT_WINS_B_VALUE, 0);
		pResultMap.put(Constants.RESULT_TIE_VALUE, 0);
		pResultMap.put(Constants.RESULT_WINS_A_VALUE, 0);
	}

	/**
	 * Resolves the outcome between two choices
	 * @param pChoiceA the choice of Player A
	 * @param pChoiceB the choice of Player B
	 * @return 1 if A wins, 0 on a tie, -1 if B wins
	 */
	public int resolveRound(Choice pChoiceA, Choice pChoiceB){
		if(pChoiceA == null || pChoiceB == null)
			return Constants.RESULT_TIE_VALUE;
		else if(pChoiceA.beats(pChoiceB))
			return Constants.RESULT_WINS_A_VALUE;
		else if (pChoiceB.beats(pChoiceA))
			return Constants.RESULT_WINS_B_VALUE;
		else
			return Constants.RESULT_TIE_VALUE;
	}

	@SuppressWarnings("StringBufferReplaceableByString")
	private void displayStrategyOptions(){
		StringBuilder lBuilder = new StringBuilder();
		lBuilder.append("\t1: " + Constants.STRATEGY_NAME_RANDOM + "(default)\n");
		lBuilder.append("\t2: " + Constants.STRATEGY_NAME_ALWAYS_ROCK + "\n");
		lBuilder.append("\t3: " + Constants.STRATEGY_NAME_ALWAYS_PAPER + "\n");
		lBuilder.append("\t4: " + Constants.STRATEGY_NAME_ALWAYS_SCISSORS + "\n");
		lBuilder.append("\t5: " + Constants.STRATEGY_NAME_ROTATE + "\n");
		lBuilder.append("\t6: " + Constants.STRATEGY_NAME_COPYCAT + "\n");
		System.out.print(lBuilder.toString());
	}
}
