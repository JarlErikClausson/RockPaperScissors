package de.krage.rockpaperscissors.choices;

public class Rock implements Choice{

	public static final String NAME = "ROCK";

	@Override
	public boolean beats(Choice pOpponentsChoice) { return pOpponentsChoice instanceof Scissors; }

	@Override
	public String getName() { return NAME; }
}
