package de.krage.rockpaperscissors.choices;

public class Scissors implements Choice{

	public static final String NAME = "SCISSORS";
	@Override
	public boolean beats(Choice pOpponentsChoice) { return pOpponentsChoice instanceof Paper; }

	@Override
	public String getName() { return NAME; }
}
