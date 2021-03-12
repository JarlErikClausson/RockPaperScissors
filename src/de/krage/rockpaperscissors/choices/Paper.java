package de.krage.rockpaperscissors.choices;

public class Paper implements Choice{

	public static final String NAME = "PAPER";

	@Override
	public boolean beats(Choice pOpponentsChoice) { return pOpponentsChoice instanceof Rock; }

	@Override
	public String getName(){
		return NAME;
	}
}
