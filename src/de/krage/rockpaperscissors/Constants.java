package de.krage.rockpaperscissors;

public class Constants {

	// List of numeric strategy assignments
	public static final int STRATEGY_NUMBER_RANDOM = 1;
	public static final int STRATEGY_NUMBER_ALWAYS_ROCK = 2;
	public static final int STRATEGY_NUMBER_ALWAYS_PAPER = 3;
	public static final int STRATEGY_NUMBER_ALWAYS_SCISSORS = 4;
	public static final int STRATEGY_NUMBER_ROTATE = 5;
	public static final int STRATEGY_NUMBER_COPYCAT = 6;

	// List of Strategy names
	public static final String STRATEGY_NAME_RANDOM = "Random Picker";
	public static final String STRATEGY_NAME_ALWAYS_ROCK = "Always choose Rock";
	public static final String STRATEGY_NAME_ALWAYS_PAPER = "Always choose Paper";
	public static final String STRATEGY_NAME_ALWAYS_SCISSORS = "Always choose Scissors";
	public static final String STRATEGY_NAME_ROTATE = "Rock, Paper, Scissors, Repeat";
	public static final String STRATEGY_NAME_COPYCAT = "Copies the opponents last figure";

	// Dialogue options
	public static final String DIALOGUE_INTRO = "Welcome to my Rock-Paper-Scissors-Simulation!\n---------------\n---------------\nNew Game\n---------------";
	public static final String DIALOGUE_SELECT_NR_ROUNDS = "\nPlease enter the number of rounds to be played:";
	public static final String DIALOGUE_SELECT_PLAYER_A = "---------------\nPlease choose from the following playstyles for player A:\n";
	public static final String DIALOGUE_SELECT_PLAYER_B = "---------------\nPlease choose from the following playstyles for player B:\n";
	public static final String DIALOGUE_PROCESSING_GAME = "---------------\n%d rounds are being played...";
	public static final String DIALOGUE_STEP_OF_TENTHOUSAND = "%d rounds finished.\n";
	public static final String DIALOGUE_GAME_FINISHED = "\nThe end results are:\n\tA won %d matches\n\tB won %d matches\n\t%d matches ended in a tie.";
	public static final String DIALOGUE_OUTRO = "\n\nThank you for playing, goodbye!";
	public static final String DIALOGUE_WRONG_INPUT = "---------------\nYour input is not valid for the given criteria. Please enter a valid value.";
	public static final String DIALOGUE_WRONG_STRATEGY_CODE = "---------------\nThe strategy code is not valid. Falling back to the Random Picker.";

	// Result values
	public static final int RESULT_WINS_A_VALUE = 1;
	public static final int RESULT_WINS_B_VALUE = -1;
	public static final int RESULT_TIE_VALUE = 0;
}
